/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;
	private int intCount;
	private int doubleCount;
	private int stringCount;


    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
      typeOfElements = new int[INITIAL_CAPACITY];
      intElements    = new int[INITIAL_CAPACITY];
      doubleElements = new double[INITIAL_CAPACITY];
      stringElements = new String[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
      return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
      String s = "[";
	  int intIndex = 0;
	  int doubleIndex = 0;
	  int stringIndex = 0;
      for(int i = 0; i < filledElements; i++){
        if(typeOfElements[i] == 0){
          s += intElements[intIndex];
          intIndex++;
        }
          else if(typeOfElements[i] == 1){
            s += doubleElements[doubleIndex];
            doubleIndex++;
          }
            else{
              s += stringElements[stringIndex];
              stringIndex++;
            }
        s += ",";
      }
      s += "]";
      return s;
    }



    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int    intValue
                       , double doubleValue
                       , String stringValue
                       ) {
                          if (filledElements == typeOfElements.length) {expand();}
                          typeOfElements[filledElements] = type;
                          if(type == 0){
                            intElements[intCount] = intValue;
                            intCount++;
                          }
                            else if(type == 1){
                              doubleElements[doubleCount] = doubleValue;
                              doubleCount++;
                            }
                              else {
                                stringElements[stringCount] = stringValue;
                                stringCount++;
                              }
						   filledElements++;
                           return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");
           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
		int newLength = typeOfElements.length * 2;
        int[] dummyInt = new int[newLength];
        double[] dummyDouble = new double[newLength];
        String[] dummyString = new String[newLength];
        int[] dummyType = new int[newLength];
        for(int i = 0; i < intCount ; i++){
          dummyInt[i] = intElements[i];
        }
        for(int i = 0; i < doubleCount ; i++){
          dummyDouble[i] = doubleElements[i];
        }
        for(int i = 0; i < stringCount ; i++){
          dummyString[i] = stringElements[i];
        }
        for(int i = 0; i < filledElements ; i++){
          dummyType[i] = typeOfElements[i];
        }
        intElements = dummyInt;
        doubleElements = dummyDouble;
        stringElements = dummyString;
        typeOfElements = dummyType;
     }

     public Element get(int index) {
       int counter = 0;
       for (int i = 0; i < index + 1; i++) {
         if (this.typeOfElements[i] == this.typeOfElements[index]) {
           counter++;
         }
       }
       Element el = new Element();
       if (typeOfElements[index] == 0) {
         el.intEl = intElements[counter];
         return el;
       } else if (typeOfElements[index] == 0) {
         el.doubleEl = doubleElements[counter];
       	 return el;
       } else {
         el.stringEl = stringElements[counter];
       	 return el;
       }
    }
}
