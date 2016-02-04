package com.company;

public class Main {

    private static int count = 5; // 초소의 개수
    private static int[][] gPoint = {{8, 3}, {7, -4}, {8, 1}, {-2, 1}, {6, -2}}; // 초소 좌표
    private static boolean[] visited = {false, false, false, false, false};

    public static void main(String[] args) {

        int cur_x = 0, cur_y = 0; // 이동할 위치
        int x= 0, y = 0; // 현재 위치
        int next_x = 0,next_y = 0; // 그 다음 위치

        // 시작점 출력
        System.out.print("(" + x + "," + y + ") -> ");

        // 각 점들에 대해서
        // 현재 방문할 초소와 그 다음 초소까지 고려하여 최적의 경로로 이동
        for(int i = 0; i < count; i++){

            // 현재 위치에서 다른 좌표들을 처리할 수 있는 것들을 표시
            for(int j = 0; j < count; j++){
                if(gPoint[j][0] == x || gPoint[j][1] == y)
                    visited[j] = true;
            }

            if(visited[i]) continue; // 이제 이동할 위치가 이미 처리된(방문된) 위치라면 다음 좌표로 이동

            // 이제 이동할 위치
            cur_x = gPoint[i][0];
            cur_y = gPoint[i][1];

            // 마지막 좌표 라면
            if(i == count - 1) {
                // 더 가까운 쪽으로 이동
                if (Math.abs(x - cur_x)  < Math.abs(y - cur_y))
                    x = cur_x;
                else
                    y = cur_y;

                System.out.println("(" + x + "," + y + ")");
                break;
            }

            // 다음 좌표
            next_x = gPoint[i + 1][0];
            next_y = gPoint[i + 1][1];

            // 그 다음 위치가 더 가깝 다면
            if((Math.abs(next_x - cur_x) + Math.abs(next_y - y)) < (Math.abs(next_x - x) + Math.abs(next_y - cur_y)))
                x = cur_x;
            else
                y = cur_y;

            System.out.print("(" + x + "," + y + ") -> ");
        }
    }
}
