import java.util.*;
/**
 * 프로그래머스
 * Level2
 * 다리를 지나는 트럭
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6})); // 8
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})); // 110
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> waitTrucksQueue = initWaitTrucksQueue(truckWeights);
        Queue<Truck> bridge = new LinkedList<>();

        int totalBridgeWeight = 0;

        // 첫번째 Truck 이 bridge 에 진입한 상태로 시작
        int second = 1;
        if (!waitTrucksQueue.isEmpty()) {
            totalBridgeWeight = waitTrucksQueue.poll();
        }
        bridge.offer(new Truck(truckWeights[0], second));

        while (!bridge.isEmpty()) {
            second++;

            // Truck 탈출
            Truck = currentTruck = bridge.peek();
            if (second - currentTruck.position >= bridgeLength) {
                bridge.poll();
                totalBridgeWeight -= currentTruck.weight;
            }

            // Truck 진입
            if (!waitTrucksQueue.isEmpty() && totalBridgeWeight + waitTrucksQueue.peek() <= weight) {
                int truckWeights = waitTrucksQueue.poll();
                bridge.offer(new Truck(truckWeights, second));
                totalBridgeWeight += truckWeights;
            }
        }
        return second;
    }

    private Queue<Integer> initWaitTrucksQueue(int[] truckWeights) {
        Queue<Integer> waitTrucksQueue = new LinkedList<>();

        for (int truck : truckWeights) {
            waitTrucksQueue.offer(truck);
        }
        return waitTrucksQueue;
    }

    public class Truck {
        int weight;
        int position;

        public Truck(int weight, int position) {
            this.weight = weight;
            this.position = position;
        }
    }
}
