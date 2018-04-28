package bw.guvaexample.collection.ImmutableSet;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class ImmutableSetTest {
	//创建一个不可变集合
	public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");

	class Foo {
		Set<Bar> bars;

		Foo(Set<Bar> bars) {
			this.bars = ImmutableSet.copyOf(bars); // defensive copy!
		}
	}

}
