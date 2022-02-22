package kotlinexample.lang.optin

fun <P1, P2, P3, P4, R> ((P1, P2, P3, P4) -> R).curried(): (P1) -> (P2) -> (P3) -> (P4) -> R {
  return { p1: P1 -> { p2: P2 -> { p3: P3 -> { p4: P4 -> this(p1, p2, p3, p4) } } } }
}
