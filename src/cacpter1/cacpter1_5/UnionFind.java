package cacpter1.cacpter1_5;

public interface UnionFind {
    void union(int p,int q);//在p和q加一个连接
    int find(int p);//返回分量标识符
    default boolean connected(int p,int q){
        int pType= find(p);
        int qType=find(q);
        if(qType==0||pType==0){
            return false;
        }
        return qType==pType;
    }
    int count();//数量
}
