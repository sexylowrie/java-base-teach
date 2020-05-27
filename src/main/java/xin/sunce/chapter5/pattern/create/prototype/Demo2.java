package xin.sunce.chapter5.pattern.create.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 深度拷贝优化版：全部数据进行更新，资源加载消耗
 * 场景描述：
 * A服务：业务需求我们维护所有关键词的搜索次数，更新时间
 * B服务：实时统计对关键的数据进行分析，更新，最终统一更新到数据库中
 * <p>
 * A服务定期从数据库中拉取新版的数据，要求A服务的数据有一致性；要么全新，要么全旧
 */
public class Demo2 {

    private Map<String, SearchWord> current = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        List<SearchWord> loadFromDataBase = loadFromDataBase();
        Map<String, SearchWord> newMap = new HashMap<>();
        long maxUpdateTime = lastUpdateTime;

        //遍历在newMap全部新建数据
        for (Map.Entry<String, SearchWord> entry : current.entrySet()) {
            SearchWord value = entry.getValue();
            newMap.put(value.getKeyword(), value);
        }

        for (SearchWord searchWord : loadFromDataBase) {
            if (searchWord.getUpdateTime() > lastUpdateTime) {
                maxUpdateTime = searchWord.getUpdateTime();
            }
            if (current.containsKey(searchWord.getKeyword())) {
                SearchWord old = newMap.get(searchWord.getKeyword());
                old.setCount(searchWord.getCount());
                old.setUpdateTime(searchWord.getUpdateTime());
            } else {
                newMap.put(searchWord.getKeyword(), searchWord);
            }
        }
        current = newMap;
        lastUpdateTime = maxUpdateTime;
    }

    private void init() {
        //模拟current初始加载
    }

    private List<SearchWord> loadFromDataBase() {
        //模拟从数据库拉取新数据
        return null;
    }


}
