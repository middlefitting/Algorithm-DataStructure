package 테스트;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenceTest {
	public static void main(String[] args) throws InterruptedException {
		// Strong Reference
		List<Object> strongList = new ArrayList<>();
		Object strongRef = new Object();
		strongList.add(strongRef);

		// Weak Reference
		WeakReference<Object> weakRef = new WeakReference<>(new Object());

		// Soft Reference
		SoftReference<Object> softRef = new SoftReference<>(new Object());

		// Phantom Reference
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		PhantomReference<Object> phantomRef = new PhantomReference<>(new Object(), referenceQueue);

		// Print before GC
		System.out.println("Before GC:");
		printReferences(strongList.get(0), weakRef, softRef, phantomRef);

		// Set strong reference to null
		strongList.set(0, null);

		// Run Garbage Collector
		System.gc();
		Thread.sleep(1000);  // Ensure GC has run

		// Print after GC
		System.out.println("After GC:");
		printReferences(strongList.get(0), weakRef, softRef, phantomRef);

		// Check Phantom Reference
		Reference<?> ref = referenceQueue.poll();
		if (ref != null) {
			System.out.println("Phantom reference has been enqueued.");
		} else {
			System.out.println("Phantom reference has NOT been enqueued.");
		}
	}

	private static void printReferences(Object strongRef, WeakReference<Object> weakRef, SoftReference<Object> softRef, PhantomReference<Object> phantomRef) {
		System.out.println("Strong Reference: " + (strongRef != null));
		System.out.println("Weak Reference: " + (weakRef.get() != null));
		System.out.println("Soft Reference: " + (softRef.get() != null));
		System.out.println("Phantom Reference: " + (phantomRef.get() != null));  // Always null
	}
}
