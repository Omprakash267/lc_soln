class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        r=[]
        a=0
        for i in nums:
            a=a+i
            r.append(a)
        return r