package TemaTest;

/**
 * Interface for Followable objects, such as users, which can be followed or
 * unfollowed
 */
public interface Followable {
  /**
   * Method to follow a user
   *
   * @param toFollow represents the user to follow
   */
  void follow(User toFollow);

  /**
   * Method to unfollow a user
   *
   * @param toUnfollow represents the user to unfollow
   */
  void unfollow(User toUnfollow);
}
