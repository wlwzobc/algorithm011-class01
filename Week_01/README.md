### **学习总结**

#### **总结**

第一周算法训练营学习，主要是平时没时间，在端午假期期间学习。说说我学习的一些感悟吧。
首先，算法学习是个持续不懈的过程，所以要给自己当前阶段定一个目标，阶段性的去实现。我报这个训练营的目的，并不是要变成算法高手，leetcode算法题目，拿来就可以马上就能正确做出来。我的主要目的是，经过训练营的练习，起码以后我碰到算法题目不会直接放弃，不会抵触，我能心态比较端正地仔细认真思考这个算法题目，根据这段时间的练习，从慢慢有了解题思路，慢慢地到能够把题目编程解出来。这是一个慢慢磨砺的过程。
其次，算法学习是一个可以刻意训练的过程。正如覃老师所说，一些算法的解题思路是你自己根本无法想出来的，所以碰到没有思路的算法题目，不要死磕，大胆地去查看解题思路，学习吸收这些解题思想，慢慢这种思想会在你的脑海中聚集起来，后续碰到类似问题，思路自然跳出来。

#### **Queue源码分析**

Queue 接口继承自 Collection 接口，同时扩展了一些队列相关接口方法：

1. boolean add(E e);
将指定的元素插入到队列中，不超过容量限制。
可能会抛出四种异常：
IllegalStateException，超过容量限制，无法添加元素；
ClassCastException，放入的元素类型与声明的泛型类型不一致；
NullPointerException，队列不接受null时，入队元素是null；
IllegalArgumentException，元素的某些属性不能入队
2. boolean offer(E e);
同add方法，但是在容量已满的情况下只会返回 false；
3. E remove();
移除栈顶元素，栈为空时，抛 NoSuchElementException 异常；
4. E poll();
同remove方法，不同的是栈为空时，返回null；
5. E element();
获取栈顶元素，并不移除，栈为空时，抛 NoSuchElementException 异常；
6. E peek();
同element方法，不同的是栈为空时，返回null；

#### **PriorityQueue源码分析**

PriorityQueue是一个优先队列，和先进先出的队列的区别在于，优先队列每次出队的元素都是优先级最高的元素。根据构造参数中Comparator来排序，没有指定则自然排序。其基于优先级堆（平衡二叉树）实现，所以不允许null元素。
PriorityQueue继承了AbstractQueue抽象类，AbstractQueue抽象类实现了Queue接口。
PriorityQueue中方法比较多，挑一些主要的分析一下：

1. offer(E e)、add(E e)
添加元素，如果队列满了，则进行扩容。通过siftUp方法来完成元素插入时的调整，保证平衡二叉树中，所有的子节点都大于它们的父节点。时间复杂度为O(log(n))。
2. remove(Object o)
删除元素，先通过indexOf(o)拿到元素索引，然后调用removeAt(i)，再调用siftDown(int k, E x),siftUp(int k, E x)，完成平衡二叉树元素位置调整。
3. poll() 
移除并获取优先级队列头节点，同时调用siftDown(int k, E x)，调整其他元素位置。

### **用add first或add last这套新的API改写Deque的代码**

``

```java
Deque<String> deque = new LinkedList<>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0){
    System.out.println(deque.removeFirst());
}
System.out.println(deque);
```