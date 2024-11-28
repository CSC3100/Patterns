package com.hotsno;

import java.util.*;

/**
 * Class used to generate move recommendations.
 *
 * @author Andrew Kulakovsky
 * @version 1.0
 */
public class RecommendationAlgorithm {
    public static HashMap<HanoiTowersState, HanoiTowersState> generateRecommendations(int diskCount) {
        HashMap<HanoiTowersState, HashSet<HanoiTowersState>> adjList = generateAdjList(diskCount);

        HashMap<HanoiTowersState, HanoiTowersState> nextMoveMap = new HashMap<>();
        Queue<HanoiTowersState> queue = new LinkedList<>();
        HashMap<HanoiTowersState, Integer> distanceMap = new HashMap<>();

        ArrayList<HanoiTowersState> solutionHanoiTowersStates = getSolutionTowerStates(adjList);
        for (HanoiTowersState solutionHanoiTowersState : solutionHanoiTowersStates) {
            queue.offer(solutionHanoiTowersState);
            distanceMap.put(solutionHanoiTowersState, 0);
            nextMoveMap.put(solutionHanoiTowersState, null);
        }

        while (!queue.isEmpty()) {
            HanoiTowersState current = queue.poll();
            int currentDistance = distanceMap.get(current);
            for (HanoiTowersState neighbor : adjList.getOrDefault(current, new HashSet<>())) {
                if (!distanceMap.containsKey(neighbor) || currentDistance + 1 < distanceMap.get(neighbor)) {
                    distanceMap.put(neighbor, currentDistance + 1);
                    queue.offer(neighbor);
                    nextMoveMap.put(neighbor, current);
                }
            }
        }

        return nextMoveMap;
    }

    private static HashMap<HanoiTowersState, HashSet<HanoiTowersState>> generateAdjList(int diskCount) {
        HanoiTowersState freshState = new HanoiTowersState(diskCount);

        HashMap<HanoiTowersState, HashSet<HanoiTowersState>> adjList = new HashMap<>();
        HashSet<HanoiTowersState> visited = new HashSet<>();
        adjDFS(adjList, freshState, visited);

        return adjList;
    }

    private static void adjDFS(HashMap<HanoiTowersState, HashSet<HanoiTowersState>> adjList,
                               HanoiTowersState hanoiTowersState,
                               HashSet<HanoiTowersState> visited) {
        if (visited.contains(hanoiTowersState)) {
            return;
        }

        for (HanoiTowersState validMove : GameLogic.getValidMoves(hanoiTowersState)) {
            adjList.putIfAbsent(hanoiTowersState, new HashSet<>());
            adjList.get(hanoiTowersState).add(validMove);
        }
        visited.add(hanoiTowersState);
        for (HanoiTowersState validMove : adjList.getOrDefault(hanoiTowersState, new HashSet<>())) {
            adjDFS(adjList, validMove, visited);
        }
    }

    private static ArrayList<HanoiTowersState> getSolutionTowerStates(HashMap<HanoiTowersState,
            HashSet<HanoiTowersState>> adjList) {
        ArrayList<HanoiTowersState> solutionHanoiTowersStates = new ArrayList<>();
        for (HanoiTowersState hanoiTowersState : adjList.keySet()) {
            if (GameLogic.isWinningState(hanoiTowersState)) {
                solutionHanoiTowersStates.add(hanoiTowersState);
            }
        }
        return solutionHanoiTowersStates;
    }
}
