package lambdalab;

public class Tester {
	
	private static boolean wChanged, xChanged, yChanged, zChanged, sum1Changed, sum2Changed, productChanged;
	static class IntRef { int value; IntRef(int v) { value = v; }}
	
	public static void main(String[] args) {
		getAndSet_intConstructor();
		getAndSet_NoArgConstructor();
		isBoundReturnsFalseWhenNotBound();
		unbindingIntPropertyThatIsNotBoundThrowsException();
		changeListenersCanBeAddedAndRemoved_AndFireAppropriately();
		changeListenersArePassedCorrectValues();
		simpleBindingAndUnbindingTest();
		throwsExceptionWhenAttemptingToSetWhileBound();
		bindingAndUnbindingWithListenersTest();
		intBindingsReturnAppropriateValues_WhenSecondOperandIsAConstant();
		intBindingsReturnAppropriateValues_WhenSecondOperandIsAnotherBinding();
		bindingToIntPropertyMultipliedByConstant();
		bindingToIntPropertyDividedByConstant_WithChangeListeners();
		changeListenersAreCorrect_ForComposedBindings();
		complexBindingsAndListeners();
		System.out.println("Success! All tests passed.");
	}
	
	private static void unbindingIntPropertyThatIsNotBoundThrowsException() {
		try {
			IntProperty p = new IntProperty(3);
			p.unbind();
		}
		catch(Exception e) {
			if(!(e instanceof IllegalArgumentException))
				throw new AssertionError("Attempting to unbind an IntProperty that is not bound produces the wrong type of exception."
						+ " It was supposed to produce an IllegalArgumentException, but instead it produced a: "
						+ e.getClass().getSimpleName());
			return;
		}
		throw new AssertionError("Attempting to unbind an IntProperty that is not bound did not throw an IllegalArgumentException.");
	}

	private static void throwsExceptionWhenAttemptingToSetWhileBound() {
		try {
			IntProperty p = new IntProperty(3);
			p.bind(IntBinding.of(2));
			p.set(10);
		}
		catch(Exception e) {
			if(!(e instanceof IllegalArgumentException))
				throw new AssertionError("Attempting to set a bound IntProperty produces the wrong type of exception. It was supposed"
						+ "to produce an IllegalArgumentException, but instead it produced a: " + e.getClass().getSimpleName());
			return;
		}
		throw new AssertionError("Attempting to set a bound IntProperty did not throw an IllegalArgumentException.");
	}

	private static void changeListenersAreCorrect_ForComposedBindings() {
		IntProperty x = new IntProperty(18), y = new IntProperty(7);
		IntBinding b = x.divide(2).subtract(y.add(3));
		IntRef arg1 = new IntRef(Integer.MIN_VALUE), arg2 = new IntRef(Integer.MIN_VALUE);
		b.addChangeListener((ov, nv) -> {
			arg1.value = ov;
			arg2.value = nv;
		});
		ensure(arg1.value == Integer.MIN_VALUE && arg2.value == Integer.MIN_VALUE, "listener was fired when it shouldn't have been.");
		x.set(x.get() + 2);
		ensure(b.get() == 0, String.format("product did not update correctly; it should have been %d, but instead it was %d.",
				0, b.get()));
		ensure(arg1.value == -1 && arg2.value == 0, String.format("change listener was passed (%d, %d) when it should"
				+ " have been passed (%d, %d)", arg1.value, arg2.value, -1, 0));
		y.set(97);
		ensure(b.get() == -90, String.format("product did not update correctly; it should have been %d, but instead it was %d.",
				-90, b.get()));
		ensure(arg1.value == 0 && arg2.value == -90, String.format("change listener was passed (%d, %d) when it should"
				+ " have been passed (%d, %d)", arg1.value, arg2.value, 0, -90));
	}

	private static void complexBindingsAndListeners() {
		wChanged = xChanged = yChanged = zChanged = sum1Changed = sum2Changed = productChanged = false;
		IntProperty w = new IntProperty(3), x = new IntProperty(0), y = new IntProperty(), z = new IntProperty(12);
		ensure("isBound() returns true when IntProperty is not bound.", !w.isBound(), !x.isBound(), !y.isBound(), !z.isBound());
		ensure("get() does not return the correct value.", w.get() == 3, x.get() == 0, y.get() == 0, z.get() == 12);
		
		IntChangeListener 	wListener = (oldValue, newValue) -> { wChanged = true; },
							xListener = (oldValue, newValue) -> { xChanged = true; },
							yListener = (oldValue, newValue) -> { yChanged = true; },
							zListener = (oldValue, newValue) -> { zChanged = true; },
							s1Listener = (oldValue, newValue) -> { sum1Changed = true; },
							s2Listener = (oldValue, newValue) -> { sum2Changed = true; },
							pListener = (oldValue, newValue) -> { productChanged = true; };
							
		w.addChangeListener(wListener);
		x.addChangeListener(xListener);
		y.addChangeListener(yListener);
		z.addChangeListener(zListener);
		ensure("change listeners fired when they should not have been", !wChanged, !xChanged, !yChanged, !zChanged);
		
		IntBinding sum1 = w.add(x);
		ensure("isBound() returns true when the IntProperty is not (or should not be) bound", !w.isBound(), !x.isBound());
		ensure("change listeners were fired when they should not have been", !wChanged, !xChanged);
		ensure("'w.add(x).get()' does not correctly return the sum of the two IntProperties 'w' and 'x'.", sum1.get() == 3);
		
		IntBinding sum2 = y.add(z);
		ensure("isBound() returns true when the IntProperty is not (or should not be) bound", !y.isBound(), !z.isBound());
		ensure("change listeners were fired when they should not have been", !yChanged, !zChanged);
		ensure("'y.add(z).get()' does not correctly return the sum of the two IntProperties 'y' and 'z'", sum2.get() == 12);
		
		IntBinding product = sum1.multiply(sum2);
		ensure("isBound() returns true when the IntProperty is not (or should not be) bound", 
				!w.isBound(), !x.isBound(), !y.isBound(), !z.isBound());
		ensure("change listeners were fired when they should not have been", !wChanged, !xChanged, !yChanged, !zChanged);
		ensure("'sum1.multiply(sum2)' does not correcly return the product of the two IntBindings 'sum1' and 'sum2'", product.get() == 36);
		
		sum1.addChangeListener(s1Listener);
		sum2.addChangeListener(s2Listener);
		product.addChangeListener(pListener);
		ensure("change listeners were fired when they should not have been", !sum1Changed, !sum2Changed, !productChanged);
		
		x.set(1);
		ensure(xChanged, "change listener was not fired when the value changed becaues of a set(...) call.");
		ensure("change listeners were fired when they should not have been", !wChanged, !yChanged, !zChanged);
		ensure(w.get() == 3, x.get() == 1, y.get() == 0, z.get() == 12);
		ensure(sum1Changed, !sum2Changed, productChanged);
		ensure(sum1.get() == 4, sum2.get() == 12, product.get() == 48);
		
		wChanged = xChanged = yChanged = zChanged = sum1Changed = sum2Changed = productChanged = false;
		z.set(0);
		ensure(!wChanged, !xChanged, !yChanged, zChanged);
		ensure(w.get() == 3, x.get() == 1, y.get() == 0, z.get() == 0);
		ensure(!sum1Changed);
		ensure(sum2Changed, "sum2 (the sum of y and z) did not fire its listeners when z changed.");
		ensure(productChanged, "product did not fire its listeners when the second operand changed in a way that changed the overall product.");
		ensure(sum1.get() == 4, sum2.get() == 0, product.get() == 0);
		
		wChanged = xChanged = yChanged = zChanged = sum1Changed = sum2Changed = productChanged = false;
		w.set(2);
		ensure("change listeners fired incorrectly.", wChanged, !xChanged, !yChanged, !zChanged);
		ensure(w.get() == 2, x.get() == 1, y.get() == 0, z.get() == 0);
		ensure(sum1Changed, "sum1 (the sum of w and x) did not fire its change listeners when w changed.");
		ensure(!sum2Changed, "sum2 (the sum of y and z) fired its change listeners when neither of its operands changed.");
		ensure(!productChanged, "product fired its change listeners when its first operand changed in a way that did NOT change the product.");
		ensure(sum1.get() == 3, sum2.get() == 0, product.get() == 0);
	}
	
	private static void bindingToIntPropertyDividedByConstant_WithChangeListeners() {
		yChanged = false;
		IntProperty x = new IntProperty(10);
		ensure(x.get() == 10, !x.isBound());
		IntProperty y = new IntProperty();
		ensure(y.get() == 0, !y.isBound());
		IntChangeListener yListener = (oldValue, newValue) -> {
			yChanged = true;
		};
		y.addChangeListener(yListener);
		ensure(!yChanged);
		
		y.bind(x.divide(7));
		ensure(y.isBound());
		ensure(yChanged);
		ensure(y.get() == 1);
		
		yChanged = false;
		x.set(71);
		ensure(!x.isBound(), x.get() == 71);
		ensure(y.isBound());
		ensure(yChanged);
		ensure(y.get() == 10);
		
		yChanged = false;
		y.unbind();
		ensure(!x.isBound(), x.get() == 71);
		ensure(!y.isBound());
		ensure(yChanged);
		ensure(y.get() == 0);
		yChanged = false;
	}

	private static void intBindingsReturnAppropriateValues_WhenSecondOperandIsAConstant() {
		IntProperty x = new IntProperty(10);
		IntBinding product = x.multiply(10);
		IntBinding quotient = x.divide(10);
		IntBinding sum = x.add(10);
		IntBinding difference = x.subtract(10);
		ensure(x.get() == 10);
		ensure(product.get() == x.get() * 10);
		ensure(quotient.get() == x.get() / 10);
		ensure(sum.get() == x.get() + 10);
		ensure(difference.get() == x.get() - 10);
		
		x.set(20);
		ensure(x.get() == 20);
		ensure(product.get() == x.get() * 10);
		ensure(quotient.get() == x.get() / 10);
		ensure(sum.get() == x.get() + 10);
		ensure(difference.get() == x.get() - 10);
	}
	
	private static void intBindingsReturnAppropriateValues_WhenSecondOperandIsAnotherBinding() {
		IntProperty x = new IntProperty(10);
		IntProperty y = new IntProperty(7);
		ensure(x.get() == 10, y.get() == 7);
		ensure(!x.isBound(), !y.isBound());
		IntBinding b = x.add(y);
		ensure(x.get() == 10, y.get() == 7);
		ensure(!x.isBound(), !y.isBound());
		ensure(b.get() == 17);
		x.set(15);
		ensure(x.get() == 15);
		ensure(b.get() == 22, "IntBinding of the sum of two other IntBindings did not update correctly when its left operand changed.");
		y.set(-1);
		ensure(y.get() == -1);
		ensure(b.get() == 14, "IntBinding of the sum of two other IntBindings did not update correctly when its right operand changed.");
	}
	
	private static void bindingToIntPropertyMultipliedByConstant() {
		IntProperty x = new IntProperty(7);
		IntProperty y = new IntProperty(-1);
		ensure(!x.isBound(), !y.isBound());
		ensure(x.get() == 7, y.get() == -1);
		
		y.bind(x.multiply(7));
		ensure(!x.isBound(), y.isBound());
		ensure(x.get() == 7, y.get() == 49);
		
		x.set(8);
		ensure(x.get() == 8, y.get() == 56);
		ensure(!x.isBound(), y.isBound());
		
		y.unbind();
		ensure(!x.isBound());
		ensure(!y.isBound(), "isBound() still returns true after unbind() is called");
		ensure(y.get() == -1, "IntProperty's int value does not return to what it was before after it has been unbound (via the unbind() method)");
	}
	
	private static void getAndSet_intConstructor() {
		IntProperty prop = new IntProperty(3);
		ensure(prop.get() == 3, "get() doesn't return the value passed to the constructor, when no set(...) calls have been made.");
		prop.set(6);
		ensure(prop.get() == 6, "get() doesn't return the value previously set.");
		prop.set(4);
		ensure(prop.get() == 4, "get() doesn't return the value previously set.");
		prop.set(4);
		ensure(prop.get() == 4, "get() doesn't return the value previously set.");
	}
	
	private static void getAndSet_NoArgConstructor() {
		IntProperty prop = new IntProperty();
		ensure(prop.get() == 0, "no-arg constructor's get method doesn't return 0 when no set(...) calls have been made");
		prop.set(6);
		ensure(prop.get() == 6, "get() doesn't return the value previously set.");
		prop.set(4);
		ensure(prop.get() == 4, "get() doesn't return the value previously set.");
		prop.set(4);
		ensure(prop.get() == 4, "get() doesn't return the value previously set.");
	}
	
	private static void isBoundReturnsFalseWhenNotBound() {
		IntProperty a = new IntProperty();
		ensure(!a.isBound(), "isBound() returns true when the IntProperty has not been bound.");
		IntProperty b = new IntProperty(5);
		ensure(!b.isBound(), "isBound() returns true when the IntProperty has not been bound.");
	}
	
	private static void bindingAndUnbindingWithListenersTest() {
		xChanged = yChanged = zChanged = false;
		IntProperty x = new IntProperty(-3);
		IntProperty y = new IntProperty(7);
		IntProperty z = new IntProperty(1_000_000);
		ensure(!x.isBound(), !y.isBound(), !z.isBound());
		ensure(x.get() == -3, y.get() == 7, z.get() == 1_000_000);
		x.addChangeListener((a,b) -> {
			xChanged = true;
		});
		y.addChangeListener((a,b) -> {
			yChanged = true;
		});
		z.addChangeListener((a,b) -> {
			zChanged = true;
		});
		ensure(!xChanged, !yChanged, !zChanged);
		
		y.bind(x);
		ensure(!x.isBound(), y.isBound(), !z.isBound());
		ensure(y.get() == x.get());
		ensure(!xChanged, !zChanged);
		ensure(yChanged, "y's change listener was not executed when y changed due to being bound.");
		
		xChanged = yChanged = zChanged = false;
		z.bind(y);
		ensure(!x.isBound(), y.isBound(), z.isBound());
		ensure(!xChanged, !yChanged);
		ensure(zChanged, "z's change listener was not executed when z changed due to being bound.");
		ensure(z.get() == y.get());
		ensure(y.get() == x.get());
		
		xChanged = yChanged = zChanged = false;
		x.set(-1);
		ensure(!x.isBound(), y.isBound(), z.isBound());
		ensure(xChanged, yChanged, zChanged);
		ensure(x.get() == -1, y.get() == -1, z.get() == -1);
		
		xChanged = yChanged = zChanged = false;
		y.unbind();
		ensure(!x.isBound(), !y.isBound(), z.isBound());
		ensure(!xChanged, yChanged, zChanged);
		ensure(x.get() == -1);
		ensure(y.get() == 7);
		ensure(z.get() == 7);
		
		xChanged = yChanged = zChanged = false;
		z.unbind();
		ensure(!x.isBound(), !y.isBound(), !z.isBound());
		ensure(!xChanged, !xChanged, zChanged);
		ensure(x.get() == -1);
		ensure(y.get() == 7);
		ensure(z.get() == 1_000_000);
	}

	private static void simpleBindingAndUnbindingTest() {
		IntProperty x = new IntProperty(3);
		IntProperty y = new IntProperty(7);
		ensure(!x.isBound(), "isBound() returns true when x is not bound");
		ensure(!y.isBound(), "isBound() returns true when y is not bound");
		ensure(x.get() == 3);
		ensure(y.get() == 7);
		y.bind(x);
		ensure(!x.isBound());
		ensure(y.isBound());
		ensure(x.get() == 3);
		ensure(y.get() == x.get(), "y's value does not equal x's value even though y is bound to x");
		y.unbind();
		ensure(!x.isBound());
		ensure(!y.isBound());
		ensure(x.get() == 3);
		ensure(y.get() == 7);
	}

	private static void changeListenersCanBeAddedAndRemoved_AndFireAppropriately() {
		yChanged = false;
		IntProperty y = new IntProperty(5);
		ensure(y.get() == 5, "y's int value is not 5 when it was initialized as 'new IntProperty(5)'");
		IntChangeListener listener = (oldValue, newValue) -> { yChanged = true; };
		y.addChangeListener(listener);
		y.set(6);
		ensure(y.get() == 6, "call to set(...) did not update the int value.");
		ensure(yChanged, "change listener for 'y' was not executed.");
		
		boolean removed = y.removeChangeListener(listener);
		ensure(removed);
		
		yChanged = false;
		y.set(7);
		ensure(y.get() == 7);
		ensure(!yChanged);
	}
	
	private static void changeListenersArePassedCorrectValues() {
		
		IntRef arg1 = new IntRef(-1), arg2 = new IntRef(-1);
		IntProperty a = new IntProperty(3);
		a.addChangeListener((oldV, newV) -> {
			arg1.value = oldV;
			arg2.value = newV;
		});
		ensure("change listeners were fired when they should not have been.", arg1.value == -1, arg2.value == -1);
		a.set(5);
		ensure(arg1.value == 3 && arg2.value == 5, String.format("change listener was passed (%d, %d) when it should"
				+ " have been passed (%d, %d)", arg1.value, arg2.value, 3, 5));
		a.set(8);
		ensure(arg1.value == 5 && arg2.value == 8, String.format("change listener was passed (%d, %d) when it should"
				+ " have been passed (%d, %d)", arg1.value, arg2.value, 5, 8));
	}
	private static void ensure(boolean... bools) {
		ensure("Failed", bools);
	}
	
	private static void ensure(String text, boolean... bools) {
		for(boolean b : bools)
			ensure(b, text);
	}
	private static void ensure(boolean b) {
		ensure(b, "Failed");
	}
	
	private static void ensure(boolean b, String text) {
		if(!b) throw new AssertionError(text);
	}
	
}
