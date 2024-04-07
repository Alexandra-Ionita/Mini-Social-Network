package TemaTest;

import java.util.ArrayList;

/**
 * This class represents the commands that can be executed.
 * It has methods for every command.
 *
 * @see App
 */
public class Commands {

  /**
   * This method creates a new user.
   *
   * @param wantedUsername represents the username of the user
   * @param wantedPassword represents the password of the user
   */
  void createUser(String wantedUsername, String wantedPassword) {
    for (User u : App.getUsers()) {
      if (u.getUsername().equals(wantedUsername)) {
        System.out.println(App.getStatus("error", "User already exists"));
        return;
      }
    }

    User user = new User(wantedUsername, wantedPassword);

    App.getUsers().add(user);

    System.out.println(App.getStatus("ok", "User created successfully"));
  }

  /**
   * This method creates a new post and adds it to the array of posts and to
   * the array of posts of the user who created the post.
   *
   * @param owner       represents the user who created the post
   * @param textForPost represents the text of the post
   */
  void createPost(String owner, String textForPost) {
    Post post = new Post(owner, textForPost);

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(owner)) {
        u.getUserPosts().add(post);
        break;
      }
    }

    App.getAllPosts().add(post);

    System.out.println(App.getStatus("ok", "Post added successfully"));
  }

  /**
   * This method deletes a post from the array of posts and from the array of
   * posts of the user who created the post.
   *
   * @param postOwner represents the user who created the post
   * @param postId    represents the id of the post
   */
  void deletePost(String postOwner, int postId) {
    App.getAllPosts().removeIf(element -> element.getId() == postId);

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(postOwner)) {
        for (Post p : u.getUserPosts()) {
          if (p.getId() == postId) {
            u.getUserPosts().remove(p);
            break;
          }
        }
        break;
      }
    }

    System.out.println(App.getStatus("ok", "Post deleted successfully"));
  }

  /**
   * This method follows or unfollows a user.
   * It adds the user who is followed to the list of users who are followed
   * by the user who executes the command. Or it removes the user who is
   * unfollowed from the list of users who are followed by the user who
   * executes the command.
   *
   * @param command         represents the command that is executed, follow or
   *                        unfollow a user
   * @param username        represents the user who executes the command
   * @param usernameCommand represents the user who is followed or unfollowed
   */
  void followUnfollow(String command, String username,
                      String usernameCommand) {
    User user = null;
    User userCommand = null;

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(username)) {
        user = u;
      }

      if (u.getUsername().equals(usernameCommand)) {
        userCommand = u;
      }
    }

    assert user != null;
    if (command.equals("-follow-user-by-username"))
      user.follow(userCommand);
    else
      user.unfollow(userCommand);

    System.out.println(App.getStatus("ok", "Operation executed successfully"));
  }

  /**
   * This method likes a post.
   * It adds the user who liked the post to the list of users who liked the
   * post by id.
   *
   * @param user     represents the user who liked the post
   * @param idToLike represents the id of the post that is liked
   */
  void likePost(String user, int idToLike) {
    Post postToLike = null;
    User userWhoLikes = null;

    for (Post p : App.getAllPosts()) {
      if (p.getId() == idToLike) {
        postToLike = p;
        break;
      }
    }

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(user)) {
        userWhoLikes = u;
      }

      assert postToLike != null;
      if (u.getUsername().equals(postToLike.getPostOwner())) {
        u.Likes++;
      }
    }


    assert postToLike != null;
    postToLike.like(userWhoLikes);

    System.out.println(App.getStatus("ok", "Operation executed successfully"));

  }

  /**
   * This method unlikes a post.
   * It removes the user who unliked the post from the list of users who
   * liked the post by id.
   *
   * @param user       represents the user who unliked the post
   * @param idToUnlike represents the id of the post that is unliked
   */
  void unlikePost(String user, int idToUnlike) {
    Post postToUnlike = null;
    User userWhoUnlikes = null;

    for (Post p : App.getAllPosts()) {
      if (p.getId() == idToUnlike) {
        postToUnlike = p;
        break;
      }
    }

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(user)) {
        userWhoUnlikes = u;
      }

      assert postToUnlike != null;
      if (u.getUsername().equals(postToUnlike.getPostOwner())) {
        u.Likes--;
      }
    }

    assert postToUnlike != null;
    postToUnlike.unlike(userWhoUnlikes);

    System.out.println(App.getStatus("ok", "Operation executed successfully"));
  }

  /**
   * This method comments a post.
   * It adds the comment to the list of comments of the post by id and to the
   * list of all comments.
   *
   * @param user        represents the user who commented the post
   * @param idToComment represents the id of the post that is commented
   * @param commentText represents the text of the comment
   */
  void commentPost(String user, int idToComment, String commentText) {
    Post postToComment = null;

    for (Post p : App.getAllPosts()) {
      if (p.getId() == idToComment) {
        postToComment = p;
        break;
      }
    }

    assert postToComment != null;
    postToComment.numberOfComments++;

    Comment commentToAdd = new Comment(user, commentText);

    postToComment.getPostComments().add(commentToAdd);

    App.getAllComments().add(commentToAdd);

    System.out.println(App.getStatus("ok", "Comment added successfully"));
  }

  /**
   * This method likes a comment.
   * It adds the user who liked the comment to the list of users who liked the
   * comment by id.
   *
   * @param user     represents the user who liked the comment
   * @param idToLike represents the id of the comment that is liked
   */
  void likeComment(String user, int idToLike) {
    User userWhoLikes = null;
    Comment commentToLike = null;

    for (Comment c : App.getAllComments()) {
      if (c.getId() == idToLike) {
        commentToLike = c;
        break;
      }
    }

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(user)) {
        userWhoLikes = u;
      }

      assert commentToLike != null;
      if (u.getUsername().equals(commentToLike.getCommentAuthor())) {
        u.Likes++;
      }
    }

    assert commentToLike != null;
    commentToLike.like(userWhoLikes);

    System.out.println(App.getStatus("ok", "Operation executed successfully"));
  }

  /**
   * This method unlikes a comment.
   * It removes the user who unliked the comment from the list of users who
   * liked the comment by id.
   *
   * @param user       represents the user who unliked the comment
   * @param idToUnlike represents the id of the comment that is unliked
   */
  void unlikeComment(String user, int idToUnlike) {
    User userWhoUnlikes = null;
    Comment commentToUnlike = null;

    for (Comment c : App.getAllComments()) {
      if (c.getId() == idToUnlike) {
        commentToUnlike = c;
        break;
      }
    }

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(user)) {
        userWhoUnlikes = u;
      }

      assert commentToUnlike != null;
      if (u.getUsername().equals(commentToUnlike.getCommentAuthor())) {
        u.Likes--;
      }
    }

    assert commentToUnlike != null;
    commentToUnlike.unlike(userWhoUnlikes);

    System.out.println(App.getStatus("ok", "Operation executed successfully"));
  }

  /**
   * This method deletes a comment from the list of comments of the post by
   * id and from the list of all comments.
   *
   * @param id represents the id of the comment that is deleted
   */
  void deleteComment(int id) {
    App.getAllComments().removeIf(element -> element.getId() == id);

    for (Post p : App.getAllPosts()) {
      for (Comment c : p.getPostComments()) {
        if (c.getId() == id) {
          p.getPostComments().remove(c);
          p.numberOfComments--;
          break;
        }
      }
    }

    System.out.println(App.getStatus("ok", "Operation executed " +
            "successfully"));

  }

  /**
   * This method displays the posts of the users that the user follows.
   *
   * @param username represents the user who executes the command
   * @param posts    represents a list of posts in which I add the posts of the
   *                 users that the user follows in order to sort them
   */
  void getFollowingsPosts(String username, ArrayList<Post> posts) {
    for (User u : App.getUsers()) {
      if (u.getUsername().equals(username)) {
        for (User fll : u.getFollowing()) {
          posts.addAll(fll.getUserPosts());
        }
        break;
      }
    }

    Post.sortPosts(posts);

    System.out.print("{'status':'ok','message': [");

    for (Post p : posts) {
      System.out.printf("{'post_id':'%d', " +
                      "'post_text':'%s', 'post_date':'%s', " +
                      "'username':'%s'}", p.getId(), p.getPostText(),
              p.currentDate, p.getPostOwner());
      if (posts.indexOf(p) != posts.size() - 1) {
        System.out.print(",");
      }
    }

    System.out.println("]}");
  }

  /**
   * This method displays the details of the posts a user has by id.
   *
   * @param postId represents the id of the post
   */
  void getPostDetails(int postId) {
    System.out.print("{'status':'ok','message': [");

    for (Post p : App.getAllPosts()) {
      if (p.getId() == postId) {
        System.out.printf("{'post_text':'%s', " +
                        "'post_date':'%s', 'username':'%s', " +
                        "'number_of_likes':'%d', 'comments': [",
                p.getPostText(),
                p.currentDate, p.getPostOwner(), p.getNumberOfLikes());

        Comment.sortComments(p.getPostComments());
        for (Comment c : p.getPostComments()) {
          System.out.printf("{'comment_id':'%d', " +
                          "'comment_text':'%s', 'comment_date':'%s', " +
                          "'username':'%s', 'number_of_likes':'%d'}",
                  c.getId(), c.getCommentText(), c.currentDate,
                  c.getCommentAuthor(), c.getNumberOfLikes());
          if (p.getPostComments().indexOf(c) != p.getPostComments().size() - 1) {
            System.out.print(",");
          } else {
            System.out.print("] ");
          }
        }
        break;
      }
    }

    System.out.println("}] }");
  }

  /**
   * This method displays the users that a user follows.
   *
   * @param username represents the user who executes the command
   */
  void getFollowing(String username) {
    for (User u : App.getUsers()) {
      if (u.getUsername().equals(username) && u.getFollowing() != null) {
        System.out.print("{'status':'ok','message': [");
        for (User fll : u.getFollowing()) {
          System.out.printf("'%s'", fll.getUsername());
          if (u.getFollowing().indexOf(fll) != u.getFollowing().size() - 1) {
            System.out.print(",");
          }
        }
        System.out.println("]}");
        break;
      }
    }
  }

  /**
   * This method displays the users that follow a user.
   *
   * @param username represents the user who executes the command
   */
  void getFollowers(String username) {
    for (User u : App.getUsers()) {
      if (u.getUsername().equals(username) && u.getFollowers() != null) {
        System.out.print("{'status':'ok','message': [");
        for (User fll : u.getFollowers()) {
          System.out.printf("'%s'", fll.getUsername());
          if (u.getFollowers().indexOf(fll) != u.getFollowers().size() - 1) {
            System.out.print(",");
          }
        }
        System.out.println("]}");
        break;
      }
    }
  }

  /**
   * This method displays the posts and their details of a user by username.
   *
   * @param username represents the user who executes the command
   * @param posts    represents a list of posts in which I add the posts of the
   *                 user in order to sort them
   */
  void getUserPosts(String username, ArrayList<Post> posts) {
    for (User u : App.getUsers()) {
      if (u.getUsername().equals(username)) {
        posts.addAll(u.getUserPosts());
        break;
      }
    }

    Post.sortPosts(posts);

    System.out.print("{'status':'ok','message': [");

    for (Post p : posts) {
      System.out.printf("{'post_id':'%d', " +
                      "'post_text':'%s', 'post_date':'%s'}", p.getId(),
              p.getPostText(),
              p.currentDate);
      if (posts.indexOf(p) != posts.size() - 1) {
        System.out.print(",");
      } else {
        System.out.print("]}");
      }
    }
  }

  /**
   * This method displays the 5 users with the most followers.
   */
  void getMostFollowed() {
    int cnt = 0;
    ArrayList<User> users = App.getUsers();

    users.sort((o1, o2) -> o2.getFollowersNumber() - o1.getFollowersNumber());

    System.out.print("{'status':'ok','message': [");

    for (User u : users) {
      cnt++;

      System.out.printf("{'username':'%s', " +
                      "'number_of_followers':'%d'}", u.getUsername(),
              u.getFollowersNumber());
      if (users.indexOf(u) != users.size() - 1 && cnt < 5) {
        System.out.print(",");
      } else {
        System.out.print(" ]}");
        break;
      }
    }
  }

  /**
   * This method displays the 5 users with the most liked posts and comments.
   */
  void getMostLiked() {
    int cnt = 0;
    ArrayList<User> users = App.users;

    users.sort((o1, o2) -> o2.Likes - o1.Likes);

    System.out.print("{'status':'ok','message': [");

    for (User u : users) {
      cnt++;

      System.out.printf("{'username':'%s', " +
                      "'number_of_likes':'%d'}", u.getUsername(),
              u.Likes);
      if (users.indexOf(u) != users.size() - 1 && cnt < 5) {
        System.out.print(",");
      } else {
        System.out.print("]}");
        break;
      }
    }
  }

  /**
   * This method displays the 5 posts with the most likes.
   */
  void getMostLikedPosts() {
    int cnt = 0;
    ArrayList<Post> posts = App.getAllPosts();

    posts.sort((o1, o2) -> o2.getNumberOfLikes() - o1.getNumberOfLikes());

    System.out.print("{'status':'ok','message': [");

    for (Post p : posts) {
      cnt++;

      System.out.printf("{'post_id':'%d', " + "'post_text':'%s'," +
                      "'post_date':'%s', 'username' :'%s', " +
                      "'number_of_likes':'%d'}",
              p.getId(),
              p.getPostText(),
              p.currentDate, p.getPostOwner(), p.getNumberOfLikes());
      if (posts.indexOf(p) != posts.size() - 1 && cnt < 5) {
        System.out.print(",");
      } else {
        System.out.print(" ]}");
      }
    }
  }

  /**
   * This method displays the 5 posts with the most comments.
   */
  void getMostCommentedPosts() {
    int cnt = 0;
    ArrayList<Post> posts = App.getAllPosts();

    posts.sort((o1, o2) -> o2.numberOfComments - o1.numberOfComments);

    System.out.print("{'status':'ok','message': [");

    for (Post p : posts) {
      cnt++;

      System.out.printf("{'post_id':'%d', " +
                      "'post_text':'%s', 'post_date':'%s', " +
                      "'username':'%s', 'number_of_comments':'%d'}",
              p.getId(),
              p.getPostText(),
              p.currentDate, p.getPostOwner(), p.numberOfComments);
      if (posts.indexOf(p) != posts.size() - 1 && cnt < 5) {
        System.out.print(",");
      } else {
        System.out.print("]}");
      }
    }
  }
}
