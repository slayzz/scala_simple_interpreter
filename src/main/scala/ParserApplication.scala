import parser.Parser

object ParserApplication extends App {
  if (args.length == 0) {
    println("""This is command line for simple mathematical operations:
You can write any count of spaces
Permitted text:
  1) Only Positive Integers
  2) Only Plus(+) and Minus(-) operators
Examples:
  1) 1 + 2 - 10
  1)    200    -  2 + 10
    """)
    System.exit(0)
  }

  val parser = new Parser(args.mkString(" "))
  parser.interpret()
}
