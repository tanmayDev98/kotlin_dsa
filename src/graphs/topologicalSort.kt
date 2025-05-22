package graphs

data class Package(
    val nameOfThePackage: String,
    val packageCode: String,
    var dependencies: List<Package>
) {
    override fun hashCode(): Int = packageCode.hashCode()

    override fun equals(other: Any?): Boolean =
        this === other || (other is Package && packageCode == other.packageCode)
}

fun main() {
//      To detect cycle in the graph
//    val x = Package(nameOfThePackage = "X", packageCode = "PKG_X", dependencies = listOf())
//    val y = Package(nameOfThePackage = "Y", packageCode = "PKG_Y", dependencies = listOf(x))
//    val z = Package(nameOfThePackage = "Z", packageCode = "PKG_Z", dependencies = listOf(y))
//    x.dependencies = listOf(z)


//      Topological Sort
    val d = Package(nameOfThePackage = "D", packageCode = "PKG_D", dependencies = listOf())
    val c = Package(nameOfThePackage = "C", packageCode = "PKG_C", dependencies = listOf(d))
    val b = Package(nameOfThePackage = "B", packageCode = "PKG_B", dependencies = listOf(d))
    val a = Package(nameOfThePackage = "A", packageCode = "PKG_A", dependencies = listOf(b, c))

    val buildOrder = resolveDependencies(a)
    println("Build order: $buildOrder")
}

//Topological Sort and finding the cycle (beingBuilt) in the graph
fun getCorrectOrder(p : Package,
                    correctOrder : MutableList<String>,
                    alreadyBuilt : HashSet<Package>,
                    builtPossible : BooleanArray,
                    beingBuilt: HashSet<Package> = HashSet()
) {

    if (p in alreadyBuilt || !builtPossible[0]) return

    beingBuilt.add(p)
    for(dependency in p.dependencies) {
        if(dependency in beingBuilt) {
            builtPossible[0] = false
            return
        }
        getCorrectOrder(dependency, correctOrder, alreadyBuilt, builtPossible, beingBuilt)
    }
    beingBuilt.remove(p)
    alreadyBuilt.add(p)
    correctOrder.addLast(p.nameOfThePackage)
}

fun resolveDependencies(p: Package) : MutableList<String> {
    val alreadyBuilt : HashSet<Package> = HashSet()
    val correctOrder : MutableList<String> = mutableListOf();
    val builtPossible : BooleanArray = BooleanArray(1) {true}
    getCorrectOrder(p, correctOrder, alreadyBuilt, builtPossible)
    return if(builtPossible[0]) correctOrder else mutableListOf()
}
