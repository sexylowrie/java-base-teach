package xin.sunce.chapter5.pattern.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 浅拷贝优化版：无法满足版本一致性
 * 场景描述：
 * A服务：业务需求我们维护所有关键词的搜索次数，更新时间
 * B服务：实时统计对关键的数据进行分析，更新，最终更新到数据库中
 * <p>
 * A服务定期从数据库中拉取新版的数据，要求A服务的数据有一致性；要么全新，要么全旧
 */
public class Demo1 {

    private Map<String, SearchWord> current = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        List<SearchWord> loadFromDataBase = loadFromDataBase();
        Map<String, SearchWord> newMap = current;
        long maxUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : loadFromDataBase) {
            if (searchWord.getUpdateTime() > lastUpdateTime) {
                maxUpdateTime = searchWord.getUpdateTime();
            }
            if (newMap.containsKey(searchWord.getKeyword())) {
                SearchWord old = newMap.get(searchWord.getKeyword());
                old.setCount(searchWord.getCount());
                old.setUpdateTime(searchWord.getUpdateTime());
            } else {
                newMap.put(searchWord.getKeyword(), searchWord);
            }
            newMap.put(searchWord.getKeyword(), searchWord);
        }
        lastUpdateTime = maxUpdateTime;
        current = newMap;
    }

    private void init(){
        //模拟current初始加载
    }

    private List<SearchWord> loadFromDataBase() {
        //模拟从数据库拉取新数据
        return null;
    }


}