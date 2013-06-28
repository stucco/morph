package converter.utils

/** A collection of various utilities.
  */
object Utils {

  /** An implicit class to provide additional methods on `String`.
    */
  implicit class StringUtils(str: String) {

    /** Indent every line in a string by one space.
      *
      * @return The indented string.
      */
    def indent: String = indent(2)

    /** Indent every line in a string by a specified number of spaces.
      *
      * @param num The number of spaces to indent every line by.
      *
      * @return The indented string.
      */
    def indent(num: Int): String =
      " " * num + str.replace("\n", "\n" + " " * num)
  }
}