package TemaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.ArrayList;

/**
 * This is a class that represents a post.
 * It implements the Likeable interface.
 * It has a constructor, getters and setters for the attributes, and methods
 * to like, unlike and sort a post by date a post.
 *
 * @see Likeable
 * @see Comment
 * @see User
 */
public class Post implements Likeable {
  String currentDate;
  public int numberOfLikes = 0;
  String postOwner;
  String postText;
  private static int postId = 1;
  private final int id;
  public int numberOfComments = 0;
  public ArrayList<Comment> postComments = new ArrayList<>();
  public ArrayList<User> postLikes = new ArrayList<>();

  /**
   * This is the constructor of the Post class.
   * It sets the date when the post was created, the user who created the post,
   * the text of the post and the id of the post.
   *
   * @param postOwner represents the user who created the post
   * @param postText  represents the text of the post
   */
  public Post(String postOwner, String postText) {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    currentDate = dateFormat.format(date);
    this.postOwner = postOwner;
    this.postText = postText;
    this.id = postId;
    postId++;
  }

  /**
   * This method returns the text of the post.
   *
   * @return the text of the post
   */
  public String getPostText() {
    return postText;
  }

  /**
   * This method returns the id of the post.
   *
   * @return the id of the post
   */
  public int getId() {
    return id;
  }

  /**
   * This method returns the owner of the post.
   *
   * @return the owner of the post
   */
  public String getPostOwner() {
    return postOwner;
  }

  /**
   * This method sets the number of likes of the post.
   *
   * @param numberOfLikes represents the number of likes of the post
   */
  public void setNumberOfLikes(int numberOfLikes) {
    this.numberOfLikes = numberOfLikes;
  }

  /**
   * This method returns the number of likes of the post.
   *
   * @return the number of likes of the post
   */
  public int getNumberOfLikes() {
    return numberOfLikes;
  }

  /**
   * This method returns the list of comments of the post.
   *
   * @return the list of comments of the post
   */
  public ArrayList<Comment> getPostComments() {
    return postComments;
  }

  /**
   * This method returns the list of users who liked the post.
   *
   * @return the list of users who liked the post
   */
  public ArrayList<User> getPostLikes() {
    return postLikes;
  }

  /**
   * This method sets the id of the post.
   *
   * @param postId represents the id of the post
   */
  public static void setPostId(int postId) {
    Post.postId = postId;
  }

  /**
   * This method adds a like to a post.
   * It adds the user who liked the post to the list of users who liked the post
   * and increments the number of likes of the post.
   *
   * @param userLiked represents the user who liked the post
   */
  public void like(User userLiked) {
    this.getPostLikes().add(userLiked);
    this.setNumberOfLikes(this.getNumberOfLikes() + 1);
  }

  /**
   * This method removes a like from a post.
   * It removes the user who unliked the post from the list of users who
   * liked the post and decrements the number of likes of the post.
   *
   * @param userUnliked represents the user who unliked the post
   */
  public void unlike(User userUnliked) {
    this.getPostLikes().remove(userUnliked);
    this.setNumberOfLikes(this.getNumberOfLikes() - 1);
  }

  /**
   * This method sorts the posts by date.
   * It uses the sort method from the Collections class to sort the posts by date.
   *
   * @param posts represents the list of posts to be sorted
   */
  public static void sortPosts(ArrayList<Post> posts) {
    posts.sort(Comparator.comparingInt(Post::getId).reversed());
  }
}
