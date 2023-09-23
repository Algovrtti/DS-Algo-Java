class DevidenConqure {
        public static int search(String arr[],int tar,int si ,int ei){
            if(si > ei){
                return -1;
            }
            // kaam
            int mid = si + (ei-si)/2; 

            // case found
            if(arr[mid] == tar){
                return mid;
            }
            // mid on l1
            if(arr[si] <= arr[mid]){
                // case a : left
                if(arr[si]<= tar && tar <= arr[mid]) {
                    return search(arr,tar,si,mid-1);
                } else{
                    // case c : right
                    return search(arr,tar,mid+1,ei);
                }
            }
            // mid on l2
            else{
                // case c : right
                if(arr[mid]<= tar && tar <= arr[ei]){
                    return search(arr,tar,mid+1,ei);
                } else {
                    // case d : left
                    return search(arr,tar,si,mid-1);
                }
            }
        }
        public static void main(String args[]){
             arr[] = { "sun", "earth", "mars", "mercury"};
            int target = 1;
            int tarIdx = search(arr,target,0,arr.length-1);
            System.out.println(tarIdx);
        }
    }

   
