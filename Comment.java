package TemaTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.Date;

/**
 * This is a class that represents a comment.
 * It implements the Likeable interface.
 * It has a constructor, getters and setters for the attributes, and methods
 * to like, unlike and sort a comment by date.
 *
 * @see Likeable
 * @see Post
 * @see User
 */
public class Comment implements Likeable {
  String currentDate;
  public ArrayList<User> commentLikes = new ArrayList<>();
  String commentAuthor;
  String commentText;
  public int numberOfLikes = 0;
  private static int commentId = 1;
  private final int id;
  public int numberOfComments = 0;

  /**
   * This method returns the id of the comment.
   *
   * @return the id of the comment
   */
  public int getId() {
    return id;
  }

  /**
   * This method sets the id of the comment.
   *
   * @param commentId represents the id of the comment
   */
  public static void setCommentId(int commentId) {
    Comment.commentId = commentId;
  }

  /**
   * This method returns the list of users who liked the comment.
   *
   * @return the list of users who liked the comment
   */
  public ArrayList<User> getCommentLikes() {
    return commentLikes;
  }

  /**
   * This method returns the author of the comment.
   *
   * @return the author of the comment
   */
  public String getCommentAuthor() {
    return commentAuthor;
  }

  /**
   * This method returns the text of the comment.
   *
   * @return the text of the comment
   */
  public String getCommentText() {
    return commentText;
  }

  /**
   * This method returns the number of likes of the comment.
   *
   * @return the number of likes of the comment
   */
  public int getNumberOfLikes() {
    return numberOfLikes;
  }

  /**
   * This method sets the number of likes of the comment.
   *
   * @param numberOfLikes represents the number of likes of the comment
   */
  public void setNumberOfLikes(int numberOfLikes) {
    this.numberOfLikes = numberOfLikes;
  }

  /**
   * This method allows a user to like a comment.
   *
   * @param userLiked represents the user who liked the comment
   *                  It adds the user who liked the comment to the list of users who liked
   *                  the comment
   */
  public void like(User userLiked) {
    this.getCommentLikes().add(userLiked);
    this.setNumberOfLikes(this.getNumberOfLikes() + 1);
  }

  /**
   * This method allows a user to unlike a comment.
   *
   * @param userUnliked represents the user who unliked the comment
   *                    It removes the user who unliked the comment from the list of users who liked
   *                    the comment
   */
  public void unlike(User userUnliked) {
    this.getCommentLikes().remove(userUnliked);
    this.setNumberOfLikes(this.getNumberOfLikes() - 1);
  }

  /**
   * This is the constructor of the Comment class.
   * It sets the date when the comment was created, the user who created the comment,
   * the text of the comment and the id of the comment.
   *
   * @param commentAuthor represents the user who created the comment
   * @param commentText   represents the text of the comment
   */
  public Comment(String commentAuthor, String commentText) {
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();
    currentDate = dateFormat.format(date);
    this.commentAuthor = commentAuthor;
    this.commentText = commentText;
    this.id = commentId;
    commentId++;
    numberOfComments++;
  }

  /**
   * This method sorts the comments by date.
   *
   * @param comments represents the list of comments
   */
  public static void sortComments(ArrayList<Comment> comments) {
    comments.sort(Comparator.comparingInt(Comment::getId).reversed());
  }
}
