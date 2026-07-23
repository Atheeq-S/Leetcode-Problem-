class Solution {

    static class Dsu {
        int[] parent;

        public Dsu(int n) {
            parent = new int[n];

            // Initially every account is its own parent
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;

            return parent[i] = find(parent[i]); // Path Compression
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            parent[px] = py;
        }
    }

    Map<String, Integer> emailToAccount = new HashMap<>();

public List<List<String>> accountsMerge(List<List<String>> accounts) {

    int n = accounts.size();

    Dsu dsu = new Dsu(n);

    /*
        STEP 1 : Union accounts having common email

        Example:

        [
         ["John","johnsmith@mail.com","john_newyork@mail.com"],
         ["John","johnsmith@mail.com","john00@mail.com"],
         ["Mary","mary@mail.com"],
         ["John","johnnybravo@mail.com"]
        ]

        Account 0 and Account 1 contain the same email:
        johnsmith@mail.com

        Therefore:
        union(0, 1)

        Both accounts now belong to the same person.
    */

    for (int i = 0; i < n; i++) {

        List<String> acc = accounts.get(i);

        for (int j = 1; j < acc.size(); j++) {

            String email = acc.get(j);

            // First time seeing this email
            if (!emailToAccount.containsKey(email)) {
                emailToAccount.put(email, i);
            }
            // Email already seen -> same person
            else {
                dsu.union(i, emailToAccount.get(email));
            }
        }
    }

    /*
        STEP 2 : Group emails by DSU parent

        emailToAccount stores:

        email -> account index

        To find the actual owner group:

        email -> account index -> parent

        Example:

        johnsmith@mail.com -> 0
        parent(0) -> 1

        Therefore:

        Parent 1 owns johnsmith@mail.com
    */

    // Parent -> Sorted Emails
    Map<Integer, TreeSet<String>> merged = new HashMap<>();

    for (String email : emailToAccount.keySet()) {

        int index = emailToAccount.get(email);

        int parent = dsu.find(index);

        merged
            .computeIfAbsent(parent, k -> new TreeSet<>())
            .add(email);
    }

    /*
        STEP 3 : Build Final Result

        merged contains:

        Parent -> Emails

        Now add the account name.

        Name can be obtained using:

        accounts.get(parent).get(0)

        Final format:

        [
          Name,
          sorted_email_1,
          sorted_email_2,
          ...
        ]
    */

    List<List<String>> result = new ArrayList<>();

    for (int parent : merged.keySet()) {

        List<String> res = new ArrayList<>();

        // Add account name
        res.add(accounts.get(parent).get(0));

        // Add sorted emails
        res.addAll(merged.get(parent));

        result.add(res);
    }

    return result;
}

}
