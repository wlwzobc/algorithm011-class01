# 学习笔记

1. ##### 递归

   - 模板

   ```java
   public void recur(int level, int param) { 
    // 递归的终止条件
    if (level > MAX_LEVEL) { 
     // process result 
     return; 
    }
    // 处理当前层逻辑
    process(level, param); 
    // 下探到下一层
    recur( level: level + 1, newParam); 
    // 如果有需要，清理当前层的状态  
   }
   ```

   

   - 要点

   抵制人肉进行递归

   找最近重复性

   要用数学归纳法思维

2. ##### 分治、回溯

   可以认为分治、回溯是一种特殊的递归。

   分治是将大问题分解为小问题递归求解，然后合并结果集（最小重复性）
   回溯主要通过不断试错去尝试分步解决问题，如果在解决问题过程中发现分步答案不能解决问题，则取消上一步或者几步的计算。

