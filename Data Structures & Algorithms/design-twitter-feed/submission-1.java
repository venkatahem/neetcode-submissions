class Twitter {

    private Set<Integer> users;
    private Map<Integer,Set<Pair>> tweets;
    private Map<Integer,Set<Integer>> follows;

    static int count = 0;

    class Pair{
        int id;
        int tweetId;

        public Pair(int id, int tweetId){
            this.id = id;
            this.tweetId = tweetId;
        }
    }


    public Twitter() {
        this.users = new HashSet<>();
        this.tweets = new HashMap<>();
        this.follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(tweets.keySet().contains(userId)){
            tweets.get(userId).add(new Pair(++count,tweetId));
        }else{
            Set<Pair> tweet = new HashSet<>();
            tweet.add(new Pair(++count,tweetId));
            tweets.put(userId,tweet);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Queue<Pair> que = new PriorityQueue<>((a,b) -> a.id - b.id);

        Set<Integer> followees = follows.getOrDefault(userId,null);
        Set<Pair> tweet = tweets.getOrDefault(userId,null);

        addTweetsToQue(tweet,que);

        if(followees != null){
            for(Integer i: followees){
                tweet = tweets.getOrDefault(i,null);
                addTweetsToQue(tweet,que);
            }
        }

        List<Integer> sortedList = new ArrayList<>();
        
        while (!que.isEmpty()) {
            sortedList.addFirst(que.poll().tweetId);
        }

        return sortedList;
    }
    
    public void follow(int followerId, int followeeId) {
        if(follows.keySet().contains(followerId)){
            follows.get(followerId).add(followeeId);
        }else{
            Set<Integer> followees = new HashSet<>();
            followees.add(followeeId);
            follows.put(followerId,followees);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.keySet().contains(followerId)){
            follows.get(followerId).remove(followeeId);
        }
    }

    private void addTweetsToQue(Set<Pair> tweet, Queue<Pair> que){
        if(tweet != null){
            for(Pair i: tweet){
                que.add(i);
                if(que.size() > 10){
                    que.poll();
                }
            }
        }
    }
}
