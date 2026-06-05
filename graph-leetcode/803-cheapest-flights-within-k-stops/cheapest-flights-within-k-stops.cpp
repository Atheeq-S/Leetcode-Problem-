class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights,
                          int src, int dst, int k) {

        vector<vector<pair<int,int>>> adj(n);

        for(auto &f : flights) {
            adj[f[0]].push_back({f[1], f[2]});
        }

        vector<vector<int>> dist(n, vector<int>(k + 2, INT_MAX));

        priority_queue<
            tuple<int,int,int>,
            vector<tuple<int,int,int>>,
            greater<>
        > pq;

        pq.push({0, 0, src});
        dist[src][0] = 0;

        while(!pq.empty()) {

            auto [cost, steps, node] = pq.top();
            pq.pop();

            if(node == dst)
                return cost;

            if(steps == k + 1)
                continue;

            for(auto [nei, wt] : adj[node]) {

                int newCost = cost + wt;

                if(newCost < dist[nei][steps + 1]) {

                    dist[nei][steps + 1] = newCost;

                    pq.push({newCost, steps + 1, nei});
                }
            }
        }

        return -1;
    }
};