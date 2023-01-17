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
// +build linux

package recycle

import (
	"errors"
	"os"
	"syscall"
)

var StatError = errors.New("fileinfo.Sys() is not *syscall.Stat_t")

func getuid(info os.FileInfo) (int64, error) {
	stat_t, ok := info.Sys().(*syscall.Stat_t)
	if !ok {
		return 0, StatError
	}
	return int64(stat_t.Uid), nil
}

func setfsuid(uid int) (err error) {
	return syscall.Setfsuid(uid)
}
