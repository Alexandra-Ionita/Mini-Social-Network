package TemaTest;

/**
 * This class checks for errors in the input.
 * It has a method for each command, which checks if the input is valid.
 * If the input is not valid, it prints an error message.
 *
 * @see App
 * @see Commands
 */
public class ChecksForErrors {
  /**
   * This method checks if the input is valid for each command.
   * If the input is not valid, it prints an error message.
   *
   * @param arg represents the input
   * @return 0 if the input is valid, 1 otherwise
   */
  int getErrors(String[] arg) {
    int err = 0;
    String command = arg[0];

    switch (command) {
      case "-create-user":
        if (arg.length == 1) {
          System.out.println(App.getStatus("error",
                  "Please provide username"));
          err = 1;
        } else if (arg.length == 2) {
          System.out.println(App.getStatus("error",
                  "Please provide password"));
          err = 1;
        }
        break;

      case "-create-post":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No text provided"));
            err = 1;
          } else {
            String text = App.getWords(arg[3]);
            if (text.codePointCount(0, text.length()) > 300) {
              System.out.println(App.getStatus("error",
                      "Post text length exceeded"));
              err = 1;
            }
          }
        }
        break;

      case "-delete-post-by-id":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No identifier was provided"));
            err = 1;
          } else {
            if (checkId(arg[3], arg[1]) == 1) {
              System.out.println(App.getStatus("error",
                      "The identifier was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-follow-user-by-username":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No username to follow was provided"));
            err = 1;
          } else {
            if (checkUserToFollow(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The username to follow was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-unfollow-user-by-username":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No username to unfollow was provided"));
            err = 1;
          } else {
            if (checkUserToUnfollow(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The username to unfollow was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-like-post":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No post identifier to like was provided"));
            err = 1;
          } else {
            if (checkPost(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The post identifier to like was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-unlike-post":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No post identifier to unlike was provided"));
            err = 1;
          } else {
            if (checkPostUnlike(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The post identifier to unlike was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-comment-post":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No text provided"));
            err = 1;
          } else {
            String text = App.getWords(arg[4]);
            if (text.codePointCount(0, text.length()) > 300) {
              System.out.println(App.getStatus("error",
                      "Comment text length exceeded"));
              err = 1;
            }
          }
        }
        break;

      case "-like-comment":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No comment identifier to like was provided"));
            err = 1;
          } else {
            if (checkComment(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The comment identifier to like was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-unlike-comment":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No comment identifier to unlike was provided"));
            err = 1;
          } else {
            if (checkCommentUnlike(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The comment identifier to unlike was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-delete-comment-by-id":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error",
                    "No identifier was provided"));
            err = 1;
          } else {
            if (checkCommentDelete(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The identifier was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-get-post-details":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error", "No " +
                    "post identifier was provided"));
            err = 1;
          } else {
            if (checkPostId(arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The post identifier was not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-get-followers":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error", "No " +
                    "username to list followers was provided"));
            err = 1;
          } else {
            if (checkUser(arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The username to list followers was " +
                              "not valid"));
              err = 1;
            }
          }
        }
        break;

      case "-get-user-posts":
        if (checkBasics(arg) == 1) {
          err = 1;
        } else {
          if (arg.length == 3) {
            System.out.println(App.getStatus("error", "No " +
                    "username to list posts was provided"));
            err = 1;
          } else {
            if (checkUserToUnfollow(arg[1], arg[3]) == 1) {
              System.out.println(App.getStatus("error",
                      "The username to list posts was " +
                              "not valid"));
              err = 1;
            }
          }
        }
        break;

      default:
        if (checkBasics(arg) == 1) {
          err = 1;
        }
        break;
    }
    return err;
  }

  /**
   * This method checks if the username and password are valid or provided.
   * If the username and password are not valid or provided, it prints an
   * error message.
   *
   * @param arg represents the input
   * @return 0 if the username and password are valid, 1 otherwise
   */
  int checkBasics(String[] arg) {
    int err = 0;

    if (arg.length == 1 || arg.length == 2) {
      System.out.println(App.getStatus("error",
              "You need to be authenticated"));
      err = 1;
    } else {
      if (checkUsernameAndPassword(arg[1], arg[2]) == 1) {
        System.out.println(App.getStatus("error", "Login failed"));
        err = 1;
      }
    }

    return err;
  }

  /**
   * This method checks if the username and password are valid.
   *
   * @param username represents the username of the user
   * @param password represents the password of the user
   * @return 0 if the username and password are valid, 1 otherwise
   */
  int checkUsernameAndPassword(String username, String password) {
    int err = 0;
    int exists = 0;

    String wantedUsername = App.getWords(username);
    String wantedPassword = App.getWords(password);

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(wantedUsername)) {
        exists = 1;

        if (!u.getPassword().equals(wantedPassword)) {
          err = 1;
        }
      }
    }

    if (exists == 0) {
      err = 1;
    }

    return err;
  }

  /**
   * This method checks if the post identifier is valid.
   *
   * @param idString represents the post identifier
   * @param author   represents the username of the user
   * @return 0 if the post identifier is valid, 1 otherwise
   */
  int checkId(String idString, String author) {
    int error = 0;
    String ID = App.getWords(idString);
    String postAuthor = App.getWords(author);
    int idInteger = Integer.parseInt(ID);

    int found = 0;

    for (Post p : App.getAllPosts()) {
      if (p.getId() == idInteger) {
        found = 1;

        if (!p.getPostOwner().equals(postAuthor)) {
          error = 1;
          break;
        }
      }
    }

    if (found == 0) {
      error = 1;
    }

    return error;
  }

  /**
   * This method checks if the user to follow is valid, if it exists and if
   * it is not already followed.
   *
   * @param userName represents the username of the user
   * @param toFollow represents the username of the user to follow
   * @return 0 if the user to follow is valid, 1 otherwise
   */
  int checkUserToFollow(String userName, String toFollow) {
    int error = 0;
    int found = 0;
    String username = App.getWords(userName);
    String userToFollow = App.getWords(toFollow);

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(userToFollow)) {
        found = 1;

        for (User f : u.getFollowers()) {
          if (f.getUsername().equals(username)) {
            error = 1;
            break;
          }
        }

        break;
      }
    }

    if (found == 0) {
      error = 1;
    }

    return error;
  }

  /**
   * This method checks if the user to unfollow is valid, if it exists and if
   * it is followed.
   *
   * @param userName           represents the username of the user
   * @param userNameToUnfollow represents the username of the user to unfollow
   * @return 0 if the user to unfollow is valid, 1 otherwise
   */
  int checkUserToUnfollow(String userName, String userNameToUnfollow) {
    String username = App.getWords(userName);
    String usernameToUnfollow = App.getWords(userNameToUnfollow);
    int err = 1;

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(usernameToUnfollow)) {
        for (User f : u.getFollowers()) {
          if (f.getUsername().equals(username)) {
            err = 0;
            break;
          }
        }
        break;
      }
    }

    return err;
  }

  /**
   * This method checks if the post identifier is valid, if it exists and if
   * the user is the owner of the post or if the user has not liked the post.
   *
   * @param usr      represents the username of the user
   * @param stringId represents the post identifier
   * @return 0 if the post identifier is valid, 1 otherwise
   */
  int checkPost(String usr, String stringId) {
    int error = 1;
    String ID = App.getWords(stringId);
    String user = App.getWords(usr);
    int postId = Integer.parseInt(ID);

    for (Post p : App.getAllPosts()) {
      if (p.getId() == postId) {
        error = 0;
        if (p.getPostOwner().equals(user)) {
          error = 1;
        } else {
          for (User u : p.getPostLikes()) {
            if (u.getUsername().equals(user)) {
              error = 1;
              break;
            }
          }
        }

        break;
      }
    }

    return error;
  }

  /**
   * This method checks if the post identifier is valid, if it exists and if
   * the user has liked the post.
   *
   * @param usr      represents the username of the user
   * @param stringId represents the post identifier
   * @return 0 if the post identifier is valid, 1 otherwise
   */
  int checkPostUnlike(String usr, String stringId) {
    int error = 1;
    String ID = App.getWords(stringId);
    String user = App.getWords(usr);
    int postId = Integer.parseInt(ID);

    for (Post p : App.getAllPosts()) {
      if (p.getId() == postId) {
        for (User u : p.getPostLikes()) {
          if (u.getUsername().equals(user)) {
            error = 0;
            break;
          }
        }

        break;
      }
    }

    return error;
  }

  /**
   * This method checks if the comment identifier is valid, if it exists and
   * if the user has not liked the comment.
   *
   * @param usr      represents the username of the user
   * @param stringId represents the comment identifier
   * @return 0 if the comment identifier is valid, 1 otherwise
   */
  int checkComment(String usr, String stringId) {
    int error = 1;
    String ID = App.getWords(stringId);
    String user = App.getWords(usr);
    int commentId = Integer.parseInt(ID);

    for (Post p : App.getAllPosts()) {
      for (Comment c : p.getPostComments()) {
        if (c.getId() == commentId) {
          error = 0;
          for (User u : c.getCommentLikes()) {
            if (u.getUsername().equals(user)) {
              error = 1;
              break;
            }
          }

          break;
        }
      }
    }

    return error;
  }

  /**
   * This method checks if the comment identifier is valid, if it exists and
   * if the user has liked the comment.
   *
   * @param usr      represents the username of the user
   * @param stringId represents the comment identifier
   * @return 0 if the comment identifier is valid, 1 otherwise
   */
  int checkCommentUnlike(String usr, String stringId) {
    int error = 1;
    String ID = App.getWords(stringId);
    String user = App.getWords(usr);
    int commentId = Integer.parseInt(ID);

    for (Post p : App.getAllPosts()) {
      for (Comment c : p.getPostComments()) {
        if (c.getId() == commentId) {
          for (User u : c.getCommentLikes()) {
            if (u.getUsername().equals(user)) {
              error = 0;
              break;
            }
          }
          break;
        }
      }
    }

    return error;
  }

  /**
   * This method checks if the comment identifier is valid, if it exists and
   * if the user is the author of the comment.
   *
   * @param usr      represents the username of the user
   * @param stringId represents the comment identifier
   * @return 0 if the comment identifier is valid, 1 otherwise
   */
  int checkCommentDelete(String usr, String stringId) {
    int error = 1;
    String ID = App.getWords(stringId);
    String user = App.getWords(usr);
    int commentId = Integer.parseInt(ID);

    for (Comment c : App.getAllComments()) {
      if (c.getId() == commentId) {
        error = 0;
        if (!c.getCommentAuthor().equals(user)) {
          error = 1;
        }
        break;
      }
    }

    return error;
  }

  /**
   * This method checks if the post identifier is valid, if it exists.
   *
   * @param stringId represents the post identifier
   * @return 0 if the post identifier is valid, 1 otherwise
   */
  int checkPostId(String stringId) {
    int error = 1;
    String ID = App.getWords(stringId);
    int postId = Integer.parseInt(ID);

    for (Post p : App.getAllPosts()) {
      if (p.getId() == postId) {
        error = 0;
        break;
      }
    }

    return error;
  }

  /**
   * This method checks if the username is valid, if it exists.
   *
   * @param usr represents the username of the user
   * @return 0 if the username is valid, 1 otherwise
   */
  int checkUser(String usr) {
    int error = 1;
    String user = App.getWords(usr);

    for (User u : App.getUsers()) {
      if (u.getUsername().equals(user)) {
        error = 0;
        break;
      }
    }

    return error;
  }
}
