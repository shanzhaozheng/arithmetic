package chapter05;

import lombok.Data;

public class ThreadedBinaryTree {

    private HeroNode root;

    private HeroNode pre;

    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
        this.ThreadedBinaryTreeInit(root);
    }


    public void threadedList(){
        HeroNode heroNode = root;
        while (heroNode != null){
            while (heroNode.getLeftType() == 0){
                heroNode = heroNode.getLeft();
            }
            System.out.println(heroNode.getNumber());
            while (heroNode.getRightType() == 1){
                heroNode = heroNode.getRight();
                System.out.println(heroNode.getNumber());
            }
            heroNode = heroNode.getRight();

        }

    }

    /**
     * 初始中序线索化
     * @param node
     */
    public void ThreadedBinaryTreeInit(HeroNode node){
        if (node == null){
            return;
        }
        ThreadedBinaryTreeInit(node.left);

        if (node.left == null){
            node.leftType = 1;
            node.left = pre;
        }

        if (pre != null && pre.right == null){
            pre.rightType = 1;
            pre.right = node;
        }
        pre = node;
        ThreadedBinaryTreeInit(node.right);
    }



    @Data
    public static class HeroNode{
        private int number;
        private HeroNode left;
        private HeroNode right;

        /**
         * 0: 子树
         * 1: 前驱后继
         */
        private int leftType;
        private int rightType;

        public HeroNode(int number) {
            this.number = number;
        }
    }
}
