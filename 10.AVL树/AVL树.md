# 平衡二叉树
定义：对于任意一个节点，左子树和右子树的高度差不能超过1。
平衡二叉树的高度和节点数量之间的关系也是O(log n)级别的。
平衡因子：平衡因子是每个节点的一个值，这个值代表的含义是这个节点的左右子树的高度的绝对值的差。

# 操作
## 节点
相对于BST来说，每个节点多了个属性值height
```java
private class Node {
    public K key;
    public V value;
    public Node left, right;
    //height表示当前节点的高度值
    public int height;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
        height = 1;
    }
}
```

## 获得平衡因子操作
平衡因子的值可以看出其实就是左孩子的深度减去右孩子的深度。
那么有几个值需要说明一下，记平衡因子为factor
factor > 1：当前节点不平衡，并且cur的左子树的深度大于cur的右子树的深度，并且达到了不平衡的地步，lh > rh+1
factor < -1:当前节点不平衡，并且cur的右子树的深度大于cur的左子树的深度，并且达到了不平衡的地步，rh > lh+1
factor > 0: 不考虑当前节点是否平衡，cur的左子树的深度大于cur的右子树的深度
factor < 0: 同上，cur的右子树的深度大于cur的左孩子的深度

```java
// 获得节点node的平衡因子
private int getBalanceFactor(Node node){
    if(node == null)
        return 0;
    return getHeight(node.left) - getHeight(node.right);
}
```

## 旋转操作
旋转操作没啥说的，科学家教我的。定理。
```java
// 对节点y进行向右旋转操作，返回旋转后新的根节点x
//        y                              x
//       / \                           /   \
//      x   T4     向右旋转 (y)        z     y
//     / \       - - - - - - - ->    / \   / \
//    z   T3                       T1  T2 T3 T4
//   / \
// T1   T2
private Node rightRotate(Node y) {
    Node x = y.left;
    Node T3 = x.right;

    // 向右旋转过程
    x.right = y;
    y.left = T3;

    // 更新height
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

    return x;
}

// 对节点y进行向左旋转操作，返回旋转后新的根节点x
//    y                             x
//  /  \                          /   \
// T1   x      向左旋转 (y)       y     z
//     / \   - - - - - - - ->   / \   / \
//   T2  z                     T1 T2 T3 T4
//      / \
//     T3 T4
private Node leftRotate(Node y) {
    Node x = y.right;
    Node T2 = x.left;

    // 向左旋转过程
    x.left = y;
    y.right = T2;

    // 更新height
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

    return x;
}
```


## 增添操作
因为AVL底层用的还是BST，所以大致操作还是差不多的，只不过在递归插入节点的时候，插入成功之后，要对当前节点进行判断当前节点是否是一个平衡的。所以在判断当前节点不是平衡的时候，大致分为4个情况
假设不平衡的节点是cur
1. LL  对cur的左节点进行右旋转
2. RR  对cur的右节点进行左旋转
3. LR  先对cur的左节点进行左旋转，然后对cur进行右旋转
4. RL  现队cur的右孩子进行右旋转，然后对cur进行左旋转

这个其实就是cur的递归过程中出现cur是不平衡的时候进行的处理(所有情况哦)。这个递归过程包括增添和删除。
其实AVL的操作和BST的操作不一样的在于在递归的时候AVL多了一个判断节点是否是平衡，如果不平衡还多了一个平衡的策略。
为什么要分4种情况呢？
因为这是科学家发现的。通过这4种情况的4种操作就能实现将一颗BST平衡化，并且保持BST的特性。



```java
// 向二分搜索树中添加新的元素(key, value)
public void add(K key, V value){
    root = add(root, key, value);
}

// 向以node为根的二分搜索树中插入元素(key, value)，递归算法
// 返回插入新节点后二分搜索树的根
private Node add(Node node, K key, V value){

    if(node == null){
        size ++;
        return new Node(key, value);
    }

    if(key.compareTo(node.key) < 0)
        node.left = add(node.left, key, value);
    else if(key.compareTo(node.key) > 0)
        node.right = add(node.right, key, value);
    else // key.compareTo(node.key) == 0
        node.value = value;

    //这以上的内容和原来的BST很像
    // 更新height
    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

    // 计算平衡因子
    int balanceFactor = getBalanceFactor(node);

    // 平衡维护
    //  1. balanceFactor是当前节点的平衡因子，如果当前节点平衡因子大于1，说明左子树的深度大于右子树的深度+1 (rl>rh+1)
    //如果小于1，说明右子树的深度大于左子树的深度+1 (rh>lh+1)
    //  2. getBalanceFactor就是求出指定节点的平衡因子，如果平衡因子大于0，说明左子树的深度大，如果小于0，就说明
    //右子树深度大
    //如果出现高度不平衡，并且cur的左子树的左子树多与cur的左子树的右子树 LL 情况
    if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
        return rightRotate(node);

    //如果cur出现高度不平衡，并且cur的右子树多于cur的右子树的左子树 RR 情况
    if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
        return leftRotate(node);

    //cur高度不平衡，并且cur的左子树的左子树少于cur的左子树的右子树 LR  情况
    if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    //cur高度不平衡，并且cur的右子树的左子树多余cur的右子树的右子树 RL  情况
    if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    return node;
}
```

## 删除操作
删除操作和BST的删除也很像，也是在每个节点进行删除之后，判断是否平衡，不平衡会进行平衡。也是4种情况。很简单。
```java
// 从二分搜索树中删除键为key的节点
public V remove(K key){

    Node node = getNode(root, key);
    if(node != null){
        root = remove(root, key);
        return node.value;
    }
    return null;
}

private Node remove(Node node, K key){

    if( node == null )
        return null;

    Node retNode;
    if( key.compareTo(node.key) < 0 ){
        node.left = remove(node.left , key);
        // return node;
        retNode = node;
    }
    else if(key.compareTo(node.key) > 0 ){
        node.right = remove(node.right, key);
        // return node;
        retNode = node;
    }
    else{   // key.compareTo(node.key) == 0

        // 待删除节点左子树为空的情况
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            // return rightNode;
            retNode = rightNode;
        }

        // 待删除节点右子树为空的情况
        else if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            // return leftNode;
            retNode = leftNode;
        }

        // 待删除节点左右子树均不为空的情况
        else{
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            //successor.right = removeMin(node.right);
            successor.right = remove(node.right, successor.key);
            successor.left = node.left;

            node.left = node.right = null;

            // return successor;
            retNode = successor;
        }
    }

    if(retNode == null)
        return null;

    // 更新height
    retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

    // 计算平衡因子
    int balanceFactor = getBalanceFactor(retNode);

    // 平衡维护
    // LL
    if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
        return rightRotate(retNode);

    // RR
    if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
        return leftRotate(retNode);

    // LR
    if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
        retNode.left = leftRotate(retNode.left);
        return rightRotate(retNode);
    }

    // RL
    if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
        retNode.right = rightRotate(retNode.right);
        return leftRotate(retNode);
    }

    return retNode;
}
```
