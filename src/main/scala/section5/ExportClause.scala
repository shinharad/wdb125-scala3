package section5.exportClause

// Export句

class Beans
class GroundCoffee
class Coffee

class Grinder:
  def grind(beans: Beans): GroundCoffee = ???
  def status: Int = ???

class Dripper:
  def drip(groundCoffee: GroundCoffee): Coffee = ???
  def status: Int = ???

class Coffeemaker(
  grinder: Grinder,
  dripper: Dripper):

  // grinderメンバのすべてをエクスポート
  export grinder.*

  // dripperのdripとstatusをエクスポート
  // statusはそのままではgrinderのもつ同名のメンバと
  // 衝突するのでdripStatusへリネーム
  export dripper.{drip, status as dripStatus}

def no1(): Unit =
  val coffeemaker = Coffeemaker(Grinder(), Dripper())
  coffeemaker.drip(coffeemaker.grind(Beans()))
