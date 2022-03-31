package com.example.main;

import java.util.Arrays;

public class HannahHolloway {

	// `N × N` chessboard
	public static final int N = 5;
	
	public static final int[] row = { 2, 1, -1, -2, -2, -1, 1, 2, 2 };
	public static final int[] col = { 1, 2, 2, 1, -1, -2, -2, -1, 1 };
	// Check if `(x, y)` is valid chessboard coordinates.

	// Note that a knight cannot go out of the chessboard
	
	private static boolean isValid(int x, int y)
	{

		if (x < 0 || y < 0 || x >= N || y >= N) {

		return false;

		}

		return true;

		}

		private static void print(int[][] visited)

		{
			for (var r: visited) {

				System.out.println(Arrays.toString(r));

				}

				System.out.println();

				}
		
		public static void SolveMatrix(int[][] visited, int x, int y, int pos)
		{
			visited[x][y] = pos;

			// if all squares are visited, print the solution

			if (pos >= N*N)

			{
				print(visited);

				// backtrack before returning

				visited[x][y] = 0;

				return;

				}
			for (int k = 0; k < 8; k++)

			{
				int newX = x + row[k];

				int newY = y + col[k];

				// if the new position is valid and not visited yet

				if (isValid(newX, newY) && visited[newX][newY] == 0) {

				SolveMatrix(visited, newX, newY, pos + 1);

				}

				}
			visited[x][y] = 0;

		}

		public static void main(String[] args)

		{

		// `visited[][]` serves two purposes:

		// 1. It keeps track of squares involved in the knight's tour.

		// 2. It stores the order in which the squares are visited.

		int[][] visited = new int[N][N];

		int pos = 1;

		// start knight tour from corner square `(0, 0)`

		SolveMatrix(visited, 0, 0, pos);

		}

		}
