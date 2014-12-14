Steam Api Android
=================

Simple android API to access steam's functionnalities.


```java
    String steamId = "xxxxxxxxxxxxxxx"
    SteamAPI api = new SteamApi(id);
    
    //API relatives to methods
    api.apiList.queryListWithKey(new SteamCallback);
    api.apiList.queryListWithoutKey(new SteamCallback);
    
    //API relatives to an user's profile and friends
    api.user.getPlayersSummaries(List<String> steamIds, new SteamCallback);
    api.user.getPlayerSummary(String steamId, new SteamCallback);
    api.user.getMyPlayerSummary(new SteamCallback);
    api.user.getFriendList(String steamId);
    api.user.getMyFriendList(new SteamCallback);
    
    //API relatives to games owned and games activities
    api.games.getMyGameLight(new SteamCallback);
    api.games.getRecentGame(String steamId, new SteamCallback);
    api.games.getRecentGame(String steamId, int limitGame, new SteamCallback);
    api.games.getMyRecentGame(new SteamCallback);
      
    //API relatives to user games' statistics
    api.userStats.getPlayerAchievementForGame(String steamId, new SteamCallback);
    api.userStats.getMyAchievementForGame(new SteamCallback);
    api.userStats.getUserStatsForGame(String steamId, new SteamCallback);
    api.userStats.getMyStatsForGame(new SteamCallback);
    
```

