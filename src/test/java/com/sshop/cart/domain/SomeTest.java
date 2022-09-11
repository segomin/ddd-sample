package com.sshop.cart.domain;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SomeTest {

	@Test
	void jsonObjTest() throws ParseException {
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "kim");
		obj1.put("age", 19L);
		obj1.put("address", null);
		obj1.put("isMarried", false);

		JSONObject obj2 = new JSONObject();
		obj2.put("name", "lee");
		obj2.put("age", 22L);
		obj2.put("address", "seoul");
		obj2.put("isMarried", true);
		obj2.put("myList", List.of("a", "b"));

		JSONArray arr = new JSONArray();
		arr.add(obj1);
		arr.add(obj2);

		JSONParser parser = new JSONParser();
		String str = "{\"name\" : \"apple\", \"id\" : 1, \"price\" : 1000}";         // JSONParser로 JSONObject로 변환        JSONParser parser = new JSONParser();        JSONObject jsonObject = (JSONObject) parser.parse(str);
		JSONObject jsonObject = (JSONObject) parser.parse(obj2.toJSONString());

		System.out.println(jsonObject);

		var list = (JSONArray) jsonObject.get("myList");
		System.out.println(list);
		System.out.println(jsonObject.get("myList").getClass());

		for (Object o : list) {
			System.out.println(o.getClass());
		}

//		System.out.println(obj1.toJSONString());
//		System.out.println(obj2.toJSONString());
//		System.out.println(arr.toJSONString());
//		System.out.println(list.getClass());

	}

	@Test
	void nullPair() {
		List<String> list = Arrays.asList("a", "b", "c", null);
		var actual = list.stream()
						 .map(a -> Tuple.of("Hi", a))
						 .filter(p -> p.right() != null)
						 .collect(Collectors.toList());
		System.out.println(actual);
	}
}

class Tuple<K, V> {
	private final K left;
	private final V right;

	private Tuple(K key, V value) {
		left = key;
		right = value;
	}

	static <K, V> Tuple of(K key, V value) {
		return new Tuple(key, value);
	}

	public String toString() {
		return String.format("[%s, %s]", left, right);
	}

	public K left() {
		return left;
	}

	public V right() {
		return right;
	}
}