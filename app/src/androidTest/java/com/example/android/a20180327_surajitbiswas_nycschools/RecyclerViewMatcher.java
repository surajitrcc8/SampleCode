package com.example.android.a20180327_surajitbiswas_nycschools;


import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
/** Helper class
 * Created by surajitbiswas on 3/27/18.
 */

public class RecyclerViewMatcher {

    private final int recyclerViewId;

    public RecyclerViewMatcher(int recyclerViewId) {
        this.recyclerViewId = recyclerViewId;
    }

    /**
     * This method return the view matcher at given position
     * @param position
     * @return
     */
    public Matcher<View> atPosition(final int position) {
        return atPositionOnView(position, -1);
    }

    /**
     * This method return view matcher at position from within the view
     * @param position
     * @param targetViewId
     * @return
     */
    public Matcher<View> atPositionOnView(final int position, final int targetViewId) {

        return new TypeSafeMatcher<View>() {
            Resources resources = null;
            View childView;

            /**
             * Generates a description of the object.
             * The description may be part of a a description of a
             * larger object of which this is just a component, so it should be worded appropriately.
             * @param description The description to be built or appended to.
             */
            public void describeTo(Description description) {
                String idDescription = Integer.toString(recyclerViewId);
                if (this.resources != null) {
                    try {
                        idDescription = this.resources.getResourceName(recyclerViewId);
                    } catch (Resources.NotFoundException var4) {
                        idDescription = String.format("%s (resource name not found)",
                                new Object[] { Integer.valueOf
                                        (recyclerViewId) });
                    }
                }

                description.appendText("with id: " + idDescription);
            }

            /**
             * The view been checked for the specific type and will never be null.
             * @param view
             * @return true if item matches, otherwise false.
             */
            public boolean matchesSafely(View view) {

                this.resources = view.getResources();

                if (childView == null) {
                    RecyclerView recyclerView =
                            (RecyclerView) view.getRootView().findViewById(recyclerViewId);
                    if (recyclerView != null && recyclerView.getId() == recyclerViewId) {
                        childView = recyclerView.findViewHolderForAdapterPosition(position).itemView;
                    }
                    else {
                        return false;
                    }
                }

                if (targetViewId == -1) {
                    return view == childView;
                } else {
                    View targetView = childView.findViewById(targetViewId);
                    return view == targetView;
                }

            }
        };
    }
}

