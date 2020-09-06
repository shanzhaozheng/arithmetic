import chapter05.ArrayBinaryTree;
import chapter05.ThreadedBinaryTree;

public class TestMain {
    public static void main(String[] args) {
        ThreadedBinaryTree.HeroNode root = new ThreadedBinaryTree.HeroNode(1);
        ThreadedBinaryTree.HeroNode heroNode1 = new ThreadedBinaryTree.HeroNode(3);
        ThreadedBinaryTree.HeroNode heroNode2 = new ThreadedBinaryTree.HeroNode(6);
        ThreadedBinaryTree.HeroNode heroNode3 = new ThreadedBinaryTree.HeroNode(8);
        ThreadedBinaryTree.HeroNode heroNode4 = new ThreadedBinaryTree.HeroNode(10);
        ThreadedBinaryTree.HeroNode heroNode5 = new ThreadedBinaryTree.HeroNode(14);

        root.setLeft(heroNode1);
        root.setRight(heroNode2);
        heroNode1.setLeft(heroNode3);
        heroNode1.setRight(heroNode4);
        heroNode2.setLeft(heroNode5);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        System.out.println(heroNode4.getLeft().getNumber() +"："+ heroNode4.getRight().getNumber());
        threadedBinaryTree.threadedList();
    }

}



