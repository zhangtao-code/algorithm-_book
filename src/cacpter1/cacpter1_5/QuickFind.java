package cacpter1.cacpter1_5;

import java.util.*;

public class QuickFind implements UnionFind{
    protected int []id;
    protected int count;
    protected int type;
    protected Map<Integer, Set<Integer>>map=new HashMap<>();
    public QuickFind(int count) {
        if(count<=0){
            throw  new IllegalArgumentException();
        }
        id=new int[count];
    }

    @Override
    public void union(int p, int q) {
        if(p<0||q<0||p>=count||q>=count){
            throw new IllegalStateException();
        }
        if(q==p){
            return;
        }
        int pType=id[p];
        int qType=id[q];
        if(pType==qType){
            return;
        }
        if(pType==0&&qType==0){
            id[p]=id[q]=++type;
            Set<Integer>set=new TreeSet<>();
            set.add(p);
            set.add(q);
            map.put(id[p],set);
            return;
        }
        if(pType==0){
            id[p]=id[q];
            map.get(id[q]).add(p);
            return;
        }
        if(qType==0){
            id[q]=id[p];
            map.get(id[p]).add(q);
            return;
        }
        //此时说明p q已经不同了,需要将qtype全部反转为ptype;
        Set<Integer>pSet=map.get(p);
        Set<Integer>qSet=map.get(q);
        if(pSet.size()>qSet.size()){
            pSet.addAll(qSet);
            for (Integer item : qSet) {
                id[item]=id[p];
            }
        }else{
            qSet.addAll(pSet);
            for (Integer item : pSet) {
                id[item]=id[q];
            }
        }
    }

    @Override
    public int find(int p) {
        if(p<0||p>=count){
            throw new IllegalStateException();
        }
        return id[p];
    }

    @Override
    public int count() {
        return map.size();
    }
}
