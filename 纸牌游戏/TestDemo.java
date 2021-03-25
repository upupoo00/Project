package Java_0122;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

class Card{
    public String suit;
    public int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "suit='" + suit + '\'' +
//                ", rank=" + rank +
//                '}';
        return "["+suit+","+rank+"]";
    }
}
class DeskCard {
    public static final String[] suits = {"♥","♠","♦","♣"};
    public List<Card> buyCard(){
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            for (int j = 1; j <13 ; j++) {
                String suit = suits[i];
                int rank = j;
                Card card = new Card(suit,rank);
                cardList.add(card);
            }
        }
        return cardList;
    }
    public void swap(List<Card> cardList,int i,int j){
        Card tmp = cardList.get(i);
        cardList.set(i,cardList.get(j));
        cardList.set(j,tmp);
    }
    public void washCard(List<Card> cardList){
        for (int i =cardList.size()-1; i >0 ; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cardList,i,rand);
        }

    }
}
public class TestDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //拿到栈顶元素，而不是删除
        System.out.println(stack.peek());
        //弹出栈顶元素
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());
    }
    public static void main2(String[] args) {
        DeskCard deskCard = new DeskCard();
        List<Card> cardList = deskCard.buyCard();
        System.out.println("============买牌===========");
        System.out.println(cardList);
        deskCard.washCard(cardList);
        System.out.println("============洗牌===========");
        System.out.println(cardList);
        System.out.println("============发牌===========");
        //三个人 每个人五张牌  轮流
        List<Card> hands1 = new ArrayList<>();
        List<Card> hands2 = new ArrayList<>();
        List<Card> hands3 = new ArrayList<>();

        //形如二维数组
        List<List<Card>> hands = new ArrayList<>();
        hands.add(hands1);
        hands.add(hands2);
        hands.add(hands3);

        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <3 ; j++) {
                //揭牌
                Card card = cardList.remove(0);
                hands.get(j).add(card);
            }
        }
        System.out.println("第一个人: ");
        System.out.println(hands1);
        System.out.println("第二个人: ");
        System.out.println(hands2);
        System.out.println("第三个人: ");
        System.out.println(hands3);
        System.out.println("剩余的牌: ");
        System.out.println(cardList);
    }

    public static List<Character>func(String str1,String str2){

        List<Character> list = new ArrayList<>();
        for (int i = 0; i <str1.length() ; i++) {
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                list.add(ch);
            }
        }
        return list;
    }

    public static void main1(String[] args) {
        List<Character> list = func("welcome to bit","come");
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i));
        }
        System.out.println(list);
    }
}
