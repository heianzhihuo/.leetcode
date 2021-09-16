#
# @lc app=leetcode.cn id=355 lang=python3
#
# [355] 设计推特
#

# @lc code=start
class Twitter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.tweetData = []#当前推文的ID
        self.tweet = {} # 用户推文
        self.follows = {} # 用户关注的人


    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        k = len(self.tweetData)
        if userId in self.tweet:
            self.tweet[userId].append(k)
        else:
            self.tweet[userId] = [k]
        self.tweetData.append(tweetId)


    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        print(self.tweetData)
        dic = {userId:-1}
        if userId in self.follows:
            for x in self.follows[userId]:
                dic[x] = -1
        news = []
        print(dic)
        while len(news)<10:
            cur = -1
            for user in dic:
                if -dic[user]<=len(self.tweet[user]):
                    if cur==-1 or cur<self.tweet[user][dic[user]]:
                        cur = self.tweet[user][dic[user]]
                        dic[user] -= 1
            print(cur) 
            print(dic)       
            if cur==-1:
                break
            news.append(self.tweetData[cur])
        return news

        


    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId in self.follows:
            self.follows[followerId].add(followeeId)
        else:
            self.follows[followerId] = {followeeId}


    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId in self.follows and followeeId in self.follows[followerId]:
            self.follows[followerId].remove(followeeId)



# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
# @lc code=end

