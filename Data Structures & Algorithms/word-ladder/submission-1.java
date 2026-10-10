class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> nGram = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                String pattern = sb.toString();
                if (!nGram.containsKey(pattern)) {
                    nGram.put(pattern, new ArrayList<>());
                }
                nGram.get(pattern).add(word);
            }
        }

        Set<String> seen = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();

        q.offer(beginWord);
        seen.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String word = q.poll();
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, '*');
                    String pattern = sb.toString();
                    if (!nGram.containsKey(pattern)) {
                        continue;
                    }
                    for (String next : nGram.get(pattern)) {
                        if (next.equals(endWord)) {
                            return level + 1;
                        }
                        if (!seen.contains(next)) {
                            seen.add(next);
                            q.offer(next);
                        }
                    }
                    nGram.remove(pattern);
                }
            }
            level++;
        }
        return 0;
    }
}
