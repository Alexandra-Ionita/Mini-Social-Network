package TemaTest;

import java.util.ArrayList;

/**
 * This is a class that represents a user.
 * It implements the Followable interface.
 * It has a constructor, getters and setters for the attributes, and methods
 * to follow and unfollow a user.
 *
 * @see Followable
 * @see Post
 * @see Comment
 */
public class User implements Followable {
  private final String username;
  private final String password;
  public int followersNumber = 0;
  public int followingNumber = 0;
  public int Likes = 0;
  public ArrayList<Post> userPosts = new ArrayList<>();
  public ArrayList<User> followers = new ArrayList<>();
  public ArrayList<User> following = new ArrayList<>();

  /**
   * This is the constructor of the User class.
   * It sets the username and the password of the user.
   *
   * @param username represents the username of the user
   * @param password represents the password of the user
   */
  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * This method returns the number of followers of the user.
   *
   * @return the number of followers of the user
   */
  public int getFollowersNumber() {
    return followersNumber;
  }

  /**
   * This method returns the number of users the user follows.
   *
   * @return the number of users the user follows
   */
  public int getFollowingNumber() {
    return followingNumber;
  }

  /**
   * This method sets the number of followers of the user.
   *
   * @param followersNumber represents the number of followers of the user
   */
  public void setFollowersNumber(int followersNumber) {
    this.followersNumber = followersNumber;
  }

  /**
   * This method sets the number of users the user follows.
   *
   * @param followingNumber represents the number of users the user follows
   */
  public void setFollowingNumber(int followingNumber) {
    this.followingNumber = followingNumber;
  }

  /**
   * This method returns the username of the user.
   *
   * @return the username of the user
   */
  public String getUsername() {
    return username;
  }

  /**
   * This method returns the password of the user.
   *
   * @return the password of the user
   */
  public String getPassword() {
    return password;
  }

  /**
   * This method returns the list of posts of the user.
   *
   * @return the list of posts of the user
   */
  public ArrayList<Post> getUserPosts() {
    return userPosts;
  }

  /**
   * This method returns the list of followers of the user.
   *
   * @return the list of followers of the user
   */
  public ArrayList<User> getFollowers() {
    return followers;
  }

  /**
   * This method returns the list of users the user follows.
   *
   * @return the list of users the user follows
   */
  public ArrayList<User> getFollowing() {
    return following;
  }

  /**
   * This method adds a user to the list of users the user follows.
   * It also adds the user to the list of followers of the user.
   * It also increments the number of users the user follows and the number
   * of followers of the user.
   *
   * @param toFollow represents the user to be followed
   */
  public void follow(User toFollow) {
    this.getFollowing().add(toFollow);
    toFollow.getFollowers().add(this);
    this.setFollowingNumber(this.getFollowingNumber() + 1);
    toFollow.setFollowersNumber(toFollow.getFollowersNumber() + 1);
  }

  /**
   * This method removes a user from the list of users the user follows.
   * It also removes the user from the list of followers of the user.
   * It also decrements the number of users the user follows and the number
   * of followers of the user.
   *
   * @param toUnfollow represents the user to be unfollowed.
   */
  public void unfollow(User toUnfollow) {
    this.getFollowing().remove(toUnfollow);
    toUnfollow.getFollowers().remove(this);
    this.setFollowingNumber(this.getFollowingNumber() - 1);
    toUnfollow.setFollowersNumber(toUnfollow.getFollowersNumber() - 1);
  }
}
