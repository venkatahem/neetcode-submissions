class TimeMap {
    Map<String, List<Integer>> keyTime;
    Map<String, Map<Integer, String>> keyVal;

    public TimeMap() {
        keyTime = new HashMap<>();
        keyVal = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyTime.containsKey(key)) {
            List<Integer> time = new ArrayList<>();
            time.add(timestamp);
            keyTime.put(key, time);

            Map<Integer, String> timeVal = new HashMap<>();
            timeVal.put(timestamp, value);
            keyVal.put(key, timeVal);

        } else {
            keyTime.get(key).add(timestamp);
            keyVal.get(key).put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {

        if (!keyTime.containsKey(key)) {
            return "";
        }

        List<Integer> temp = keyTime.get(key);

        int l = 0;
        int r = temp.size() - 1;

        // Index of the largest timestamp <= requested timestamp
        int ansIndex = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (temp.get(mid) <= timestamp) {
                ansIndex = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (ansIndex == -1) {
            return "";
        }

        int actualTimestamp = temp.get(ansIndex);

        return keyVal.get(key).get(actualTimestamp);
    }
}