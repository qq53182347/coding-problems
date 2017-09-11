package liugh.test01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 遍历map {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("强引用", "不会被垃圾回收器");
		map.put("软引用", "在内存不足时被回收");
		map.put("弱引用", "一旦发现弱引用对象就会回收");
		map.put("虚引用", "个对象仅持有虚引用，那么它相当于没有引用,任何时候被回收");
		// 第一种：普遍使用，二次取值            通过Map.keySet遍历key和value：
		// Set<String> keySet = map.keySet();
		for (String key : map.keySet()) {
			System.out.println("key= " + key + " and value= " + map.get(key));
		}
		// 第二种                                                    通过Map.entrySet使用iterator遍历key和value：
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
		// 第三种：推荐，尤其是容量大时         通过Map.entrySet遍历key和value
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		}
		// 第四种                                                    通过Map.values()遍历所有的value，但不能遍历key
		for (String v : map.values()) {
			System.out.println("value= " + v);
		}
	}
}

