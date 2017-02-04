Key point here is that, at each mid, if you move towards the direction of semi-peak (5,7,x - > move right), you'll end up at some peak.
public int findPeakElement(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;
        while(low < high) {
            mid = low + (high-low)/2;
            if(a[mid] < a[mid+1]) low = mid+1;
            else high = mid;
        }
        return low;
    }
