package com.yc.Leetcode.MJ_03.com.mj;

public class Asserts {
	public static void test(boolean v) {
		if (v) return;
		System.err.println(new RuntimeException().getStackTrace()[1]);
	}
}

