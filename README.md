#### Name: Ioniță Alexandra-Mihaela
#### Personal Email: alexandraionita901@gmail.com

# Mini Social Network

### Homework description:
In this homework I have created a mini social network. The network has users, 
posts and comments. You can create users and posts, comment on posts, like and
dislike posts and comments, delete posts and comments, follow and unfollow 
users.

### Implementation details:
For implementing this homework I have used 6 classes and 2 interfaces.

### Classes used:
- App: the main class, where the program starts
- User: the class that contains data about the users
- Post: the class that contains data about the posts
- Comment: the class that contains data about the comments
- ChecksForErrors: the class that contains methods for checking errors with 
the provided strings which lead to not getting the command done
- Commands: the class that contains methods for executing the commands

### Interfaces used:
- Likeable: the interface that contains methods for liking and disliking 
posts and comments
- Followable: the interface that contains methods for following and 
unfollowing users

### The implementation of each command if there are no errors:
- create-user: I create a user with the given username and password and add it 
to the list of all users
- create-post: I create a post with the given author and text and I increment 
its unique id and add it to the list of all posts and to the list of the 
user posts
- delete-post: I search for the posts' id in the array with all the posts and 
delete it from there and from the list of the user posts
- follow-user-by-username: I search for the user in the array with all the users
and save the user that wants to follow and also the user that is followed. 
Then I add the user that is followed to the list of the following of the user
that wants to follow and I add the user that wants to follow to the list of
the followers of the user that is followed and increment the number of 
followers of the user that is followed and the number of following of the user
that wants to follow
- unfollow-user-by-username: same as follow-user-by-username, but I remove 
and increment instead
- like-post: I search for the post in the array with all the posts and save it.
Then I add the user that likes the post to the list of the users that liked
the post and increment the number of likes of the post and the number of 
likes for the post owner
- unlike-post: same as like-post, but I remove and decrement instead
- like-comment: I search for the comment in the array with all the comments and
save it. Then I add the user that likes the comment to the list of the users
that liked the comment and increment the number of likes of the comment and
the number of likes for the comment owner
- unlike-comment: same as like-comment, but I remove and decrement instead
- get-followings-posts: I search for the user in the array with all the users
and when I find it I save all the posts from the users it follows in a list
and sort them by their id (which is the same as sorting by date because the 
biggest id is the newest post)
- get-user-posts: I search for the user in the array with all the users and 
when I find it I save all its posts in a list and sort them by their id
- get-post-details: I search for the post in the array with all the posts and
when I find it I print its details. To print the comments I copy them from 
the posts' array list of comments and sort them by id
- comment-post: I search for the post in the array with all the posts and 
save it. Then I create a comment with the given text and author and increment
its unique id and add it to the list of all comments and to the list of the
post comments
- delete-comment-by-id: I search for the comment in the array with all the 
comments and delete it from there and from the list of the post comments 
from the post it belongs to
- get-following: I search for the user in the array with all the users and 
when I find it I print its following list
- get-followers: I search for the user in the array with all the users and 
when I find it I print its followers list
- get-most-liked-posts: I sort the posts by the number of likes and print the
first 5 posts
- get-most-commented-posts: I sort the posts by the number of comments and
print the first 5 posts
- get-most-followed-users: I sort the users by the number of followers and
print the first 5 users
- get-most-liked-users: I sort the users by the number of likes and print the
first 5 users
- clean-up: I clear all the users, posts and comments lists and set the post 
id and comment id to 1 again

### To Add:
- I would add a login command and a logout command, so it would not be 
necessary to provide the username and password for each command. It would be 
like -login -u username -p password, and have errors for wrong username, 
wrong password, username not provided, password not provided. If I have a 
login command I only need to add the name of the user for other commands. 
For the logout command the username should pe provided to search for the 
user and set it as being logged out. If the user tries to do a command being 
logged out, an error should occur.
- I would also add a command for changing the password and one for changing 
the username. For changing the password, the user would have to be logged 
in and its status will be set to logged out after. For both commands the 
username should be provided.
- I would add a command for deleting the account.
- I would add a command to reply to the comments, but only to comments 
  because if 
you could reply to another reply it would be harder. 
- I would add commands to edit the posts and comments, but only if you are the 
owner of the post/comment.
- I would add a command to delete a comment from another user to tour post.
All of these require the user to be logged in.

- I think that the messages shown when there are errors should be different 
for when the username was not found and when the password was wrong. I also 
think that the messages should be different for when the id was not valid 
and when the user does not have permission to delete that post or comment. 
Messages could also be different for example when the username to follow 
does not exist and when the user already follows that user. 
