package TemaTest;

/**
 * An interface for likeable objects, such as posts and comments
 */
public interface Likeable {
  /**
   * Method to like a post or comment
   *
   * @param userLiked represents the user who liked the post or comment
   */
  void like(User userLiked);

  /**
   * Method to unlike a post or comment
   *
   * @param userUnliked represents the user who unliked the post or comment
   */
  void unlike(User userUnliked);
}
