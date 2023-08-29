package Q17_11_Word_Distance

class LocationPair(var location1: Int, var location2: Int) {

  // Setting initial locations using the provided parameters in primary constructor
  setLocations(location1, location2)

  def setLocations(first: Int, second: Int): Unit = {
    location1 = first
    location2 = second
  }

  def setLocations(loc: LocationPair): Unit = {
    setLocations(loc.location1, loc.location2)
  }

  def distance(): Int = {
    math.abs(location1 - location2)
  }

  def isValid: Boolean = {
    location1 >= 0 && location2 >= 0
  }

  def updateWithMin(loc: LocationPair): Unit = {
    if (!isValid || loc.distance < distance) {
      setLocations(loc.location1, loc.location2)
    }
  }


  override def toString: String = s"($location1, $location2)"
}
