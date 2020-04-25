#!/usr/bin/env python
"""
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""


def twosum_1(nums,target):
   for i in xrange(len(nums)):
      for j in range(i+1,len(nums)):
         if nums[i] + nums[j] == target:
            return [i,j]


def twosum_2(nums,target):
   cache = {}
   for i in xrange(len(nums)):
      cache[nums[i]] = i

   for i in xrange(len(nums)):
      compliment = target - nums[i]

      if compliment in cache and compliment != nums[i]:
         return [i, cache[compliment] ]


def main():
   input1 = [1,3, 5, 4]
   input2 = [2, 5 , 0 , 3 , 4]
   input3 = [1,2 , 5 , -1 , 4]

   print "using approach 1 ....."
   print twosum_1(input1, 4)
   print twosum_1(input2, 4)
   print twosum_1(input3, 4)

   print "using approach 2 ....."
   print twosum_2(input1, 4)
   print twosum_2(input2, 4)
   print twosum_2(input3, 4)


if __name__ == '__main__':
   main()
