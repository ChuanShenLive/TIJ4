//: generics/WatercolorSets.java
package generics;

import java.util.EnumSet;
import java.util.Set;

import generics.watercolors.Watercolors;

import static generics.watercolors.Watercolors.*;
import static net.mindview.util.Print.*;
import static sc.chuanshen.util.Sets.*;

public class WatercolorSets {
	public static void main(String[] args) {
		Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);

		print("set1: " + set1);
		print("set2: " + set2);
		
		print("union(set1, set2): " + union(set1, set2));
		Set<Watercolors> subset = intersection(set1, set2);
		print("intersection(set1, set2): " + subset);
		print("difference(set1, subset): " + difference(set1, subset));
		print("difference(set2, subset): " + difference(set2, subset));
		print("complement(set1, set2): " + complement(set1, set2));
	}
} /* Output:
set1: [BRILLIANT_RED, cRIMSON, MAGENTA, ROSE_MADDER, VIOLEF, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE]
set2: [CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER, BURNT_UMBER]
union(set1, set2): [MAGENTA, COBALT_BLUE_HUE, VIOLEF, VIRIDIAN_HUE, BURNT_SIENNA, ULTRAMARINE, CERULEAN_BLUE_HUE, BURNT_UMBER, BRILLIANT_RED, PHTHALO_BLUE, YELLOW_OCHRE, SAP_GREEN, cRIMSON, ROSE_MADDER, RAW_UMBER, PERMANENT_GREEN]
intersection(set1, set2): [COBALT_BLUE_HUE, VIRIDIAN_HUE, ULTRAMARINE, CERULEAN_BLUE_HUE, PHTHALO_BLUE, PERMANENT_GREEN]
difference(set1, subset): [cRIMSON, MAGENTA, VIOLEF, ROSE_MADDER, BRILLIANT_RED]
difference(set2, subset): [BURNT_SIENNA, BURNT_UMBER, YELLOW_OCHRE, RAW_UMBER, SAP_GREEN]
complement(set1, set2): [MAGENTA, VIOLEF, BURNT_SIENNA, BURNT_UMBER, BRILLIANT_RED, YELLOW_OCHRE, SAP_GREEN, cRIMSON, ROSE_MADDER, RAW_UMBER]
*///:~
