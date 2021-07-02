package algorithm.simulation;

import java.util.*;

/**
 * Programmers
 * Level3
 * 다단계 칫솔 판매
 */
public class ToothBrushPyramidSelling {


    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Person> peopleMap = initPeopleMap(enroll);

        // 부모 설정
        for (int i = 0; i < referral.length; i++) {
            peopleMap.get(enroll[i]).parent = peopleMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            addProfit(peopleMap.get(seller[i]), amount[i] * 100);
        }

        return getResult(enroll, peopleMap);
    }

    private Map<String, Person> initPeopleMap(String[] enroll) {
        Map<String, Person> peopleMap = new HashMap<>();
        peopleMap.put("-", new Person("-"));

        for (String name : enroll) {
            peopleMap.put(name, new Person(name));
        }
        return peopleMap;
    }

    private int[] getResult(String[] enroll, Map<String, Person> people) {
        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = people.get(enroll[i]).profit;
        }

        return answer;
    }

    /**
     * 한명의 Person에게 이익이 생길 때 이익은 2가지 조건을 만족할 경우 10%가 떼인다.
     * 1. 부모가 존재하고
     * 2. 10%가 1원 이상일 경우 (profit / 10 != 0)
     * 이 두 조건을 만족할 경우 90% 이익만 현재 Person에 저장하고
     * 10%는 부모에게 넘겨준다.
     * 그럼 부모는 10%의 이익을 갖고 위의 조건을 다시 확인한다.
     * 조건을 하나라도 만족하지 못할 경우 100%의 이익은 모두 현재 Person이 가져간다.
     * 모든 계산이 끝나면, enroll 배열에 쓰여진 이름 순서대로 각자의 이익을 answer에 넣는다.
     */
    private void addProfit(Person person, int profit) {
        int profitForParent = profit / 10;
        if (profitForParent != 0 && person.parent != null) {
            person.profit += profit - profitForParent;
            addProfit(person.parent, profitForParent);
        } else {
            person.profit += profit;
        }
    }

    /**
     * 트리를 생성하려면 부모 또는 자식을 저장해줘야 해서 이를 위해 Person 클래스를 정의한다.
     * enroll 배열의 값을 이용해서 Person 객체를 만들어주고,
     * Person 객체들을 Map에 저장한다.
     * 후에 referral 배열을 이용해 Map에 저장된 Person 객체간의 부모 자식 관계를 정의하여
     * 트리를 만들 수 있다.
     */
    static class Person {
        String name;
        Person parent;
        int profit;

        public Person(String name) {
            this.name = name;
            this.parent = null;
            this.profit = 0;
        }
    }
}
