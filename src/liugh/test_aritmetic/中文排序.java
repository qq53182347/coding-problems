package liugh.test_aritmetic;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

public class 中文排序 {
    public static void main(String[] args)  {
        
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("name", "中国");
        Map<String, Object> map1=new HashMap<String, Object>();
        map1.put("name", "北京");
        Map<String, Object> map2=new HashMap<String, Object>();
        map2.put("name", "首都");
        Map<String, Object> map3=new HashMap<String, Object>();
        map3.put("name", "new york");
        
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        listSort(list);
        System.out.println(list);
    }
    
    public static void listSort(List<Map<String, Object>> resultList) {
        Collections.sort(resultList, new Comparator<Map<String, Object>>() {

            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1=MapUtils.getString(o1, "name");
                String name2=MapUtils.getString(o2, "name");
                Collator instance = Collator.getInstance(Locale.CHINA);
                return instance.compare(name1, name2);

            }
        });
    }
}