package bw.guvaexample.collection;
import com.google.common.collect.ImmutableSet;

import java.util.Set;
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
