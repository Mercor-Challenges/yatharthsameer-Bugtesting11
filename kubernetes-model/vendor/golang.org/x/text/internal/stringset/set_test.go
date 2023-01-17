/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Copyright 2016 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package stringset

import "testing"

func TestStringSet(t *testing.T) {
	testCases := [][]string{
		{""},
		{"∫"},
		{"a", "b", "c"},
		{"", "a", "bb", "ccc"},
		{"    ", "aaa", "bb", "c"},
	}
	test := func(tc int, b *Builder) {
		set := b.Set()
		if set.Len() != len(testCases[tc]) {
			t.Errorf("%d:Len() = %d; want %d", tc, set.Len(), len(testCases[tc]))
		}
		for i, s := range testCases[tc] {
			if x := b.Index(s); x != i {
				t.Errorf("%d:Index(%q) = %d; want %d", tc, s, x, i)
			}
			if p := Search(&set, s); p != i {
				t.Errorf("%d:Search(%q) = %d; want %d", tc, s, p, i)
			}
			if set.Elem(i) != s {
				t.Errorf("%d:Elem(%d) = %s; want %s", tc, i, set.Elem(i), s)
			}
		}
		if p := Search(&set, "apple"); p != -1 {
			t.Errorf(`%d:Search("apple") = %d; want -1`, tc, p)
		}
	}
	for i, tc := range testCases {
		b := NewBuilder()
		for _, s := range tc {
			b.Add(s)
		}
		b.Add(tc...)
		test(i, b)
	}
	for i, tc := range testCases {
		b := NewBuilder()
		b.Add(tc...)
		for _, s := range tc {
			b.Add(s)
		}
		test(i, b)
	}
}
